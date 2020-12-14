package com.suep.sos.Dao;

import com.suep.sos.Entity.Survey;
import com.suep.sos.Entity.SurveyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SurveyDao extends JpaRepository<Survey, Integer> {

    List<SurveyInfo> findByUserId(int userId);
    Survey findById(int id);
}
