package controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import belajar_java_hibernate.util.HibernateUtil;
import org.springframework.web.servlet.mvc.SimpleFormController;

/** @author ryan */

    
public class ViewController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("tampil");
                //Session session = HibernateUtil.getSessionFactory().getCurrentSession();
                Session session = HibernateUtil.currentSession();
                session.beginTransaction();
                List result = session.createQuery("from Dvd").list();
                mv.addObject("dataDvd", result);
                session.getTransaction().commit();
                return mv;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
} 
//        public class ViewController extends SimpleFormController {
//            public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1)
//                throws Exception {
//                ModelAndView mv = new ModelAndView("tampil");
//                Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//                session.beginTransaction();
//                List result = session.createQuery("from Dvd").list();
//                mv.addObject("dataDvd", result);
//                session.getTransaction().commit();
//                return mv;
//        }
//    }
//}

//    @Override
//    protected void doSubmitAction(Object command) throws Exception {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
//
