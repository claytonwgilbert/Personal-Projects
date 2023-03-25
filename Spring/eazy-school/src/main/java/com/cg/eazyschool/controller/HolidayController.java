package com.cg.eazyschool.controller;

import com.cg.eazyschool.model.Holiday;
import com.cg.eazyschool.repository.HolidaysRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class HolidayController {

    private HolidaysRepository holidaysRepository;

    public HolidayController(HolidaysRepository holidaysRepository) {
        this.holidaysRepository = holidaysRepository;
    }

    @GetMapping("/holidays/{display}")
    public String displayHolidayPage(Model model,
                                     @PathVariable String display
                                     //@RequestParam(required = false) boolean federal
                                     //@RequestParam(required = false) boolean festival
                                     ){
        /*
        In memory data
        List<Holiday> holidays = Arrays.asList(
                new Holiday(" Jan 1 ","New Year's Day", Holiday.Type.FESTIVAL),
                new Holiday(" Oct 31 ","Halloween", Holiday.Type.FESTIVAL),
                new Holiday(" Nov 24 ","Thanksgiving Day", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25 ","Christmas", Holiday.Type.FESTIVAL),
                new Holiday(" Jan 17 ","Martin Luther King Jr. Day", Holiday.Type.FEDERAL),
                new Holiday(" July 4 ","Independence Day", Holiday.Type.FEDERAL),
                new Holiday(" Sep 5 ","Labor Day", Holiday.Type.FEDERAL),
                new Holiday(" Nov 11 ","Veterans Day", Holiday.Type.FEDERAL)
        );
        */

        Iterable<Holiday> holidays = holidaysRepository.findAll();
        List<Holiday> holidaysList = StreamSupport.stream(holidays.spliterator(), false).collect(Collectors.toList());
        Holiday.Type[] types = Holiday.Type.values();
        for(Holiday.Type type : types){
            model.addAttribute(type.toString(), holidaysList.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList()));
        }
        //Query Params
        //model.addAttribute("federal", federal);
        //model.addAttribute("festival", festival);

        //Path Params
        if(display != null && display.equalsIgnoreCase("all")){
            model.addAttribute("federal", true);
            model.addAttribute("festival", true);
        }else if(display != null && display.equalsIgnoreCase("federal")){
            model.addAttribute("federal", true);
        }else{
            model.addAttribute("festival", true);
        }

        return "holidays";
    }
}
