package com.suep.sos.Dao;

import com.suep.sos.Entity.Survey;
import com.suep.sos.Entity.SurveyEditBase;
import com.suep.sos.Entity.SurveyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyDao extends JpaRepository<Survey, Integer> {

    List<SurveyInfo> findByUserId(int userId);
    SurveyEditBase findById(Long id);
}
