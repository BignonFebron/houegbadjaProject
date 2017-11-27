package com.bootcamp.controllers;

import com.bootcamp.models.Media;
import com.bootcamp.version.ApiVersions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.Level;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController("MediaController")
@RequestMapping("/media")
@Api(value = "Media API", description = "Media API")
public class MediaController {

    @RequestMapping(method = RequestMethod.POST, value = "/")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Create a new media", notes = "Create a new media")
    public ResponseEntity<Media> createMedia(@RequestBody Media media) {

        HttpStatus httpStatus = HttpStatus.OK;
        return new ResponseEntity<Media>(new Media(), httpStatus);
    }
}
