package com.waxofalltrades.liftoff_capstone_vinyl_destination.controllers;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.dto.ItemConditionTypeDTO;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.*;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.AlbumRepository;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.ConditionTypeRepository;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.FormatTypeRepository;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.ItemRepository;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class SearchController {

    @Autowired
    private AlbumRepository albumRepository;

    @RequestMapping("search")
    public String search(Model model) {
   /*      I think this is dependent on the specific labels within the SQL database.  Probably ought to nail those down this week.

        But maybe not as much as it seems.  If we  only search by album and artist--which almost always will probably be the only two things that anyone would want to search for--then it's fair to assume that "album" and "artist" will be names of the column headers.

        In GA4, SearchController imported ListController.
    */
    }

}
