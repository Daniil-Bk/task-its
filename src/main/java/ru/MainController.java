package ru;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.io.ByteArrayInputStream;
import java.io.IOException;


@Controller
public class MainController {

    private Example1 example1;
    private Example2 example2;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("example1JSP", new Example1());
        modelAndView.addObject("example2JSP", new Example2());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/check1")
    public ModelAndView check1(@ModelAttribute("example1JSP") Example1 example1) {
        ModelAndView modelAndView = new ModelAndView();
        this.example1 = example1;
        modelAndView.addObject("example1JSP", example1);
        example1.setResult(Checker.findSubstring(example1.getA1(), example1.getA2()));
        modelAndView.setViewName("example1");

        return modelAndView;
    }

    @RequestMapping(value = "/saveExample1", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> saveExample1() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        byte[] buf = mapper.writeValueAsBytes(example1);

        return ResponseEntity
                .ok()
                .contentLength(buf.length)
                .contentType(
                        MediaType.parseMediaType("application/octet-stream"))
                .header("Content-Disposition", "attachment; filename=\"any_name.json\"")
                .body(new InputStreamResource(new ByteArrayInputStream(buf)));

    }

    @RequestMapping(value = "/uploadExample1", method = RequestMethod.POST)
    public ModelAndView uploadExample1(@RequestParam("file") MultipartFile file) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        ObjectMapper mapper = new ObjectMapper();
        byte[] buf = file.getBytes();
        try {
            example1 = mapper.readValue(buf, Example1.class);
        } catch (NullPointerException | UnrecognizedPropertyException e) {
            example1 = new Example1();
            example1.setResult("exception");
        }
        modelAndView.addObject("example1JSP", example1);
        try {
            example1.setResult(Checker.findSubstring(example1.getA1(), example1.getA2()));
        } catch (Exception e) {
            example1.setResult(e.getMessage());
        }
        modelAndView.setViewName("example1");
        return modelAndView;
    }

    @RequestMapping(value = "/check2")
    public ModelAndView check2(@ModelAttribute("example2JSP") Example2 example2) {
        ModelAndView modelAndView = new ModelAndView();
        this.example2 = example2;
        modelAndView.addObject("example2JSP", example2);
        try {
            example2.setResult(Checker.expanded(example2.getNumber()));
        } catch (Exception e) {
            example2.setResult(e.getMessage());
        }
        modelAndView.setViewName("example2");

        return modelAndView;
    }

    @RequestMapping(value = "/saveExample2", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> saveExample2() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        byte[] buf = mapper.writeValueAsBytes(example2);

        return ResponseEntity
                .ok()
                .contentLength(buf.length)
                .contentType(
                        MediaType.parseMediaType("application/octet-stream"))
                .header("Content-Disposition", "attachment; filename=\"any_name.json\"")
                .body(new InputStreamResource(new ByteArrayInputStream(buf)));

    }

    @RequestMapping(value = "/uploadExample2", method = RequestMethod.POST)
    public ModelAndView uploadExample2(@RequestParam("file") MultipartFile file) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        ObjectMapper mapper = new ObjectMapper();
        byte[] buf = file.getBytes();
        try {
            example2 = mapper.readValue(buf, Example2.class);
        } catch (NullPointerException | UnrecognizedPropertyException e) {
            example2 = new Example2();
            example2.setResult("exception");
        }
        modelAndView.addObject("example2JSP", example2);
        try {
            example2.setResult(Checker.expanded(example2.getNumber()));
        } catch (Exception e) {
            example2.setResult(e.getMessage());
        }
        modelAndView.setViewName("example2");
        return modelAndView;
    }
}