package th.mfu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.transaction.Transactional;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import th.mfu.domain.Concert;
import th.mfu.domain.Performer;
import th.mfu.domain.Seat;

@Controller
public class ConcertController {
    // TODO: define repository for concert with @Autowired

    ConcertRepository concertRepo;
    SeatRepository seatRepo;

     // TODO: define repository for concert with @Autowired
    @Autowired
    private ConcertRepository concertRepository;

    @Autowired
    private SeatRepository seatRepository;

    //Constructor for Controller
    public ConcertController(ConcertRepository repository, SeatRepository seatRepository) {
        this.concertRepo = repository;
        this.seatRepo = seatRepository;
    }

    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/concerts")
    public String listConcerts(Model model) {
        model.addAttribute("concerts", concertRepo.findAll());
        return "list-concert";
    }

    @GetMapping("/add-concert")
    public String addAConcertForm(Model model) {
        model.addAttribute("newconcert", new Concert());
        return "add-concert-form";
    }

    @PostMapping("/concerts")
    public String saveConcert(@ModelAttribute Concert newconcert) {
        concertRepo.save(newconcert);
        return "redirect:/concerts";
    }

    //TODO: add @Transactional
    @Transactional
    @GetMapping("/delete-concert/{id}")
    public String deleteConcert(@PathVariable long id) {
        //TODO: delete related seats
        concertRepository.deleteById(id);
        //TODO: delete concert from DB
        concertRepository.deleteById(id);
        //TODO: redirect to /concerts list concerts
        return "redirect:/concerts";
    }

    @GetMapping("concert/{id}/concert")
    public String showAddSeatForm(Model model, @PathVariable Long id) {

        //TODO: find seats by concert id
        Seat seats = seatRepository.findById(id).get();
        //TODO: add found seats to model
        model.addAttribute("seats", seatRepository.findById(id));
        //TODO: find concert by id
        Concert concert = concertRepository.findById(id).get();
        //TODO: define an empty seat
        Seat emptySeat = new Seat();
        //TODO: set concert to the empty seat
        emptySeat.setNumber("Enter number");
        emptySeat.setZone("Enter Zone");
        //TODO: add newseat to the model
        model.addAttribute("emptySeat",emptySeat);
        //TODO: return a template for seat-mgmt
        return "seat-mgmt";
    }

    @PostMapping("/concert/{id}/seat")
    public String saveSeat(@ModelAttribute Seat newseat, @PathVariable Long id) {
        //TODO: find concert by id
        Concert concert = concertRepository.findById(id).get();
        //TODO: set concert to the new seat
        Seat seats = new Seat(newseat.getNumber(), newseat.getZone(), newseat.isBooked());
        //TODO: save new seat
        seatRepository.save(seats);
        //TODO: redict to /concerts/id/seats where id is concert id
        return "redirect:/concerts";
    }
}
