package com.suep.sos.Service.Implementation;

import com.suep.sos.Dao.SurveyDao;
import com.suep.sos.Entity.Survey;
import com.suep.sos.Entity.SurveyInfo;
import com.suep.sos.Service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyServiceImp implements SurveyService {

    @Autowired
    SurveyDao surveyDao;

    @Override
    public List<SurveyInfo> getAllSurvey(Integer id) {
        return surveyDao.findByUserId(id);
    }
}
