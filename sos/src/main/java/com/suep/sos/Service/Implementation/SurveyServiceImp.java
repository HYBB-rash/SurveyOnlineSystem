package com.suep.sos.Service.Implementation;

import com.alibaba.fastjson.JSON;
import com.suep.sos.Dao.DetailDao;
import com.suep.sos.Dao.SurveyDao;
import com.suep.sos.Entity.Detail;
import com.suep.sos.Entity.Survey;
import com.suep.sos.Entity.SurveyEditBase;
import com.suep.sos.Entity.SurveyInfo;
import com.suep.sos.Entity.Vue.Choice;
import com.suep.sos.Entity.Vue.VueQuestion;
import com.suep.sos.Entity.Vue.VueSurvey;
import com.suep.sos.Service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class SurveyServiceImp implements SurveyService {

    public static final int Trash = 2;
    public static final int End = 0;
    public static final int New = 1;
    public static final int Important = 3;

    @Autowired
    SurveyDao surveyDao;
    @Autowired
    DetailDao detailDao;

    @Override
    public List<SurveyInfo> getAllSurvey(Integer id) {
        return surveyDao.findByUserId(id);
    }

    private String getDay(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    private void storeDetail(VueQuestion question, Long surveyId) {

        Detail detail = new Detail();
        detail.setQuestion(question.getQuestion());
        detail.setSurveyId(surveyId);
        detail.setType(question.getType());
        detail.setChoices(question.getChoices().toString());
        detailDao.save(detail);
    }

    @Override
    public Boolean storeSurvey(VueSurvey survey) {
        Survey storeSurvey = new Survey();
        storeSurvey.setUserId(survey.getUserId());
        storeSurvey.setTitle(survey.getSurveyTitle());
        storeSurvey.setCount(0);
        storeSurvey.setInstruction(survey.getInstruction());
        storeSurvey.setDay(getDay());
        storeSurvey.setStatus(New);
        System.out.println(survey);
        Survey res =  surveyDao.save(storeSurvey);
        Long id = res.getId();
        System.out.println(id);
        for (VueQuestion question : survey.getForms())
            storeDetail(question, id);
        return true;
    }

    private void createSurvey(VueSurvey survey, SurveyEditBase surveyInfo, List<Detail> details) {
        survey.setUserId(surveyInfo.getUserId());
        survey.setSurveyTitle(surveyInfo.getTitle());
        survey.setInstruction(surveyInfo.getInstruction());
        List<VueQuestion> vueQuestions = createVueQuestions(details);
        survey.setForms(vueQuestions);
    }

    private List<VueQuestion> createVueQuestions(List<Detail> details) {
        List<VueQuestion> vueQuestions = new LinkedList<>();
        for (Detail detail : details) {
            VueQuestion question = new VueQuestion();
            question.setId(detail.getId());
            question.setQuestion(detail.getQuestion());
            question.setType(detail.getType());
            System.out.println(detail.getChoices());
            List<Choice> choices = JSON.parseArray(detail.getChoices(), Choice.class);
            question.setChoices(choices);
            vueQuestions.add(question);
        }
        return vueQuestions;
    }

    @Override
    public VueSurvey getSurvey(Long id) {
        SurveyEditBase surveyInfo = surveyDao.findById(id);
        List<Detail> details = detailDao.findBySurveyId(id);

        VueSurvey survey = new VueSurvey();
        createSurvey(survey, surveyInfo, details);
        return survey;
    }
}
