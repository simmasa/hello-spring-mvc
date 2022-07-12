package jana60.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class controller {
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/ora")
	public String ora(Model prova) {
		LocalDateTime ora = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		prova.addAttribute("dt",ora.format(dtf));
		return "home";
	}
	
	@GetMapping("/Natale")
	public String isIt (Model prova) {
		LocalDateTime oggi = LocalDateTime.now();
		int day = oggi.getDayOfMonth();
		int month= oggi.getMonthValue();
		if ((day==25) && (month==12)) {
			String nat = "Non è NataleE' NATALE!";
			prova.addAttribute("nat",nat);
			return "Nat";
		} else {
			String not = "Non è Natale";
			prova.addAttribute("nat",not);
			return "Nat";
		}
	}
}
