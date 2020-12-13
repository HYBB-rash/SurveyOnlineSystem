package com.suep.sos.Dao;

import com.suep.sos.Entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyDao extends JpaRepository<Survey, Integer> {

    Survey findByUserId(int userId);

}
