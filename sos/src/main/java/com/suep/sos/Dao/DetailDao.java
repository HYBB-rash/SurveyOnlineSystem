package com.suep.sos.Dao;

import com.suep.sos.Entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailDao extends JpaRepository<Detail, Integer> {

    // get
    Detail findAllBySurveyId(int surveyId);

    // to
}
