package com.suep.sos.Controller;

import com.suep.sos.Entity.PostId;
import com.suep.sos.Entity.Survey;
import com.suep.sos.Entity.SurveyInfo;
import com.suep.sos.Entity.UserId;
import com.suep.sos.Result.Result;
import com.suep.sos.Result.ResultFactory;
import com.suep.sos.Service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    SurveyService surveyService;

    @CrossOrigin
    @PostMapping(value = "/api/survey")
    @ResponseBody
    public Result getSurveyInfo(@RequestBody PostId id) {
        List<SurveyInfo> surveys = surveyService.getAllSurvey(id.getId());
        return ResultFactory.buildSuccessResult(surveys);
    }

}
