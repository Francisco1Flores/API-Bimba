package com.negocioBimba.negocioBimba.web;


import com.negocioBimba.negocioBimba.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public String cliente() {
        return "clientes";
    }

    @RequestMapping(value = "/pedidos", method = RequestMethod.GET)
    public String pedido() {
        return "pedidos";
    }

    @RequestMapping(value = "/productos", method = RequestMethod.GET)
    public String producto(@ModelAttribute(value = "product") Product product) {
        return "productos";
    }
}
