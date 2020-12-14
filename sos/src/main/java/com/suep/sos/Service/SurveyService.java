package com.suep.sos.Service;

import com.suep.sos.Entity.Survey;
import com.suep.sos.Entity.SurveyInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SurveyService {

    List<SurveyInfo> getAllSurvey(Integer id);
}
