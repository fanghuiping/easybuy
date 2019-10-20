package com.fp.easybuy.controller;

import com.fp.easybuy.pojo.easybuy.Order;
import com.fp.easybuy.pojo.easybuy.Order_detail;
import com.fp.easybuy.pojo.easybuy.Product;
import com.fp.easybuy.pojo.easybuy.User;
import com.fp.easybuy.repository.Order_detail_repository;
import com.fp.easybuy.repository.Order_repository;
import com.fp.easybuy.repository.User_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

/**
 * 保存订单控制器
 */
@Controller
public class SaveOrderController {
    @Autowired
    Order_repository orderRepository;
    @Autowired
    Order_detail_repository orderDetailRepository;
    @Autowired
    User_repository userRepository;

    @RequestMapping("/SaveOrder")
    public String saveOrder(HttpServletRequest request)
    {
        //用户
        User user = userRepository.findByLoginName(request.getSession().getAttribute("err").toString());
        float price = zunPrice(request);
        String address = request.getSession().getAttribute("userAddress").toString();

        Order order = orderRepository.save(new Order(user.getId().intValue(),
                user.getLoginName(),
                address,
                new Date(System.currentTimeMillis()),
                price,
                randomStr(32)
        ));

        //订单
        orderDetail(request, order.getId());
        Clear(request.getSession());
        return "shopping-result";
    }

    /**
     * 生成随机数
     * @param i
     * @return
     */
    public static String randomStr(int i)
    {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            //生成一个97-122之间的int类型整数--为了生成小写字母
            int intValL = (int) (Math.random() * 26 + 97);
            //生成一个65-90之间的int类型整数--为了生成大写字母
            int intValU = (int) (Math.random() * 26 + 65);
            //生成一个30-39之间的int类型整数--为了生成数字
            int intValN = (int) (Math.random() * 10 + 48);

            int intVal = 0;
            int r = (int) (Math.random() * 3);

            if (r == 0) {
                intVal = intValL;
            } else if (r == 1) {
                intVal = intValU;
            } else {
                intVal = intValN;
            }

            sb.append((char) intVal);
        }
        return sb.toString();
    }

    //订单总金额
    public float zunPrice(HttpServletRequest request)
    {
        float cost = 0f;
        List<Product> products = (List<Product>) request.getSession().getAttribute("product");
        String[] number = request.getSession().getAttribute("number").toString().split("\\,");
        int i = 0;
        for (Product product : products) {
            if(product!=null)
            {
                float price = product.getPrice() * Integer.valueOf(number[i]);
                cost = cost + price;
                ++i;
            }
        }
        return cost;
    }
    //订单F
    public void orderDetail(HttpServletRequest request, Long id)
    {
        HttpSession session = request.getSession();
        List<Product> products = (List<Product>) request.getSession().getAttribute("product");
        String[] number = session.getAttribute("number").toString().split("\\,");
        int i = 0;
        for (Product product : products) {
            if(product != null)
            {
                Integer quantity = Integer.valueOf(number[i]);
                float price = product.getPrice();
                float cost = price * quantity;
                orderDetailRepository.save(new Order_detail(id.intValue(),
                        product.getId().intValue(),
                        quantity,
                        cost
                ));
                ++i;
            }
        }

    }
    //清理
    public void Clear(HttpSession session)
    {
        session.removeAttribute("product");
        session.removeAttribute("number");
        ShoppingCartController.productList.clear();
    }
}
