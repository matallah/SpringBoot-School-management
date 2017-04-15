package cz.vse.xkadp12;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TestBean {

    public String getHello() {
        return "Hello world!!!";
    }

}
