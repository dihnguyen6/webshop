package com.mrKhoai.webshop.controller.web;

import com.mrKhoai.webshop.objects.Carousel;
import com.mrKhoai.webshop.repositories.CarouselRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "/admin")
public class AdminRest {

    private static final Logger LOGGER = LogManager.getLogger(AdminRest.class);

    @Autowired
    private CarouselRepository carouselRepository;

    @RequestMapping(value = "/clean-car", method = RequestMethod.GET)
    public void cleanCarousel() throws IOException {
        /*File folder = new File(System.getProperty("user.home"), "/carousel");
        if (folder.exists()) {
            FileUtils.cleanDirectory(folder);
        }*/

        carouselRepository.deleteAll();
    }

    @RequestMapping(value = "/edit-car", method = RequestMethod.POST)
    public void editCarousel(@RequestPart("file") MultipartFile request,
                             @RequestParam(name = "index") String index) throws IOException {
        /*File folder = new File(System.getProperty("user.home"), "/carousel");
        if (!folder.exists()) {
            folder.mkdir();
        }
        File file = new File(System.getProperty("user.home"), "/carousel/carousel" + index);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        FileOutputStream ostream = new FileOutputStream(file);
        ostream.write(request.getBytes());
        ostream.flush();
        ostream.close();*/

        Carousel carousel = new Carousel();
        carousel.setFoto(request.getBytes());

        carouselRepository.save(carousel);
    }
}
