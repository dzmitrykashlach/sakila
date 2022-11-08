package flux.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

@Controller
public class PaymentController {


    @Autowired
    private PaymentRepository paymentRepository;

    @RequestMapping("/flux/ui/payments")
    public String index(final Model model) {

        // loads 1 and display 1, stream data, data driven mode.
        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(paymentRepository.findAll(), 1);
        model.addAttribute("payments", reactiveDataDrivenMode);
        return "index";

    }
}
