package hello.springmvc.basic.requestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {

    @RequestMapping({"/hello-basic1", "hello-basic2"})
    public String helloBasic() {
        log.info("helloBasic");
        return "Ok";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String userId) {
        log.info("mappingPath userId={}", userId);
        return "Ok";
    }

    @GetMapping("/mapping/{userId}/orders/{orderId}")
    public String mappingPath(
            @PathVariable("userId") String userId,
            @PathVariable("orderId") String orderId
    ) {
        log.info("mappingPath userId={} orderId={}", userId, orderId);
        return "Ok";
    }

    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam(@RequestParam("mode") String mode) {
        log.info("mappingParam mode={}", mode);
        return "Ok";
    }

    @PostMapping(value = "/mapping-header", headers = "mapping-header=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "Ok";
    }

    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "Ok";
    }

    @PostMapping(value = "/mapping-produces", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces() {
        log.info("mappingProduces");
        return "Ok";
    }
}
