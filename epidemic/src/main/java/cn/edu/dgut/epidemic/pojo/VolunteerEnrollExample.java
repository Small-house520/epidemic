package cn.edu.dgut.epidemic.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VolunteerEnrollExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VolunteerEnrollExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andVolunteerIdIsNull() {
            addCriterion("VOLUNTEER_ID is null");
            return (Criteria) this;
        }

        public Criteria andVolunteerIdIsNotNull() {
            addCriterion("VOLUNTEER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andVolunteerIdEqualTo(Integer value) {
            addCriterion("VOLUNTEER_ID =", value, "volunteerId");
            return (Criteria) this;
        }

        public Criteria andVolunteerIdNotEqualTo(Integer value) {
            addCriterion("VOLUNTEER_ID <>", value, "volunteerId");
            return (Criteria) this;
        }

        public Criteria andVolunteerIdGreaterThan(Integer value) {
            addCriterion("VOLUNTEER_ID >", value, "volunteerId");
            return (Criteria) this;
        }

        public Criteria andVolunteerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("VOLUNTEER_ID >=", value, "volunteerId");
            return (Criteria) this;
        }

        public Criteria andVolunteerIdLessThan(Integer value) {
            addCriterion("VOLUNTEER_ID <", value, "volunteerId");
            return (Criteria) this;
        }

        public Criteria andVolunteerIdLessThanOrEqualTo(Integer value) {
            addCriterion("VOLUNTEER_ID <=", value, "volunteerId");
            return (Criteria) this;
        }

        public Criteria andVolunteerIdIn(List<Integer> values) {
            addCriterion("VOLUNTEER_ID in", values, "volunteerId");
            return (Criteria) this;
        }

        public Criteria andVolunteerIdNotIn(List<Integer> values) {
            addCriterion("VOLUNTEER_ID not in", values, "volunteerId");
            return (Criteria) this;
        }

        public Criteria andVolunteerIdBetween(Integer value1, Integer value2) {
            addCriterion("VOLUNTEER_ID between", value1, value2, "volunteerId");
            return (Criteria) this;
        }

        public Criteria andVolunteerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("VOLUNTEER_ID not between", value1, value2, "volunteerId");
            return (Criteria) this;
        }

        public Criteria andCampusIdIsNull() {
            addCriterion("CAMPUS_ID is null");
            return (Criteria) this;
        }

        public Criteria andCampusIdIsNotNull() {
            addCriterion("CAMPUS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCampusIdEqualTo(Long value) {
            addCriterion("CAMPUS_ID =", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdNotEqualTo(Long value) {
            addCriterion("CAMPUS_ID <>", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdGreaterThan(Long value) {
            addCriterion("CAMPUS_ID >", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CAMPUS_ID >=", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdLessThan(Long value) {
            addCriterion("CAMPUS_ID <", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdLessThanOrEqualTo(Long value) {
            addCriterion("CAMPUS_ID <=", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdIn(List<Long> values) {
            addCriterion("CAMPUS_ID in", values, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdNotIn(List<Long> values) {
            addCriterion("CAMPUS_ID not in", values, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdBetween(Long value1, Long value2) {
            addCriterion("CAMPUS_ID between", value1, value2, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdNotBetween(Long value1, Long value2) {
            addCriterion("CAMPUS_ID not between", value1, value2, "campusId");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedIsNull() {
            addCriterion("IS_QUALIFIED is null");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedIsNotNull() {
            addCriterion("IS_QUALIFIED is not null");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedEqualTo(String value) {
            addCriterion("IS_QUALIFIED =", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedNotEqualTo(String value) {
            addCriterion("IS_QUALIFIED <>", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedGreaterThan(String value) {
            addCriterion("IS_QUALIFIED >", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedGreaterThanOrEqualTo(String value) {
            addCriterion("IS_QUALIFIED >=", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedLessThan(String value) {
            addCriterion("IS_QUALIFIED <", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedLessThanOrEqualTo(String value) {
            addCriterion("IS_QUALIFIED <=", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedLike(String value) {
            addCriterion("IS_QUALIFIED like", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedNotLike(String value) {
            addCriterion("IS_QUALIFIED not like", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedIn(List<String> values) {
            addCriterion("IS_QUALIFIED in", values, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedNotIn(List<String> values) {
            addCriterion("IS_QUALIFIED not in", values, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedBetween(String value1, String value2) {
            addCriterion("IS_QUALIFIED between", value1, value2, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedNotBetween(String value1, String value2) {
            addCriterion("IS_QUALIFIED not between", value1, value2, "isQualified");
            return (Criteria) this;
        }

        public Criteria andEnrollTimeIsNull() {
            addCriterion("ENROLL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEnrollTimeIsNotNull() {
            addCriterion("ENROLL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEnrollTimeEqualTo(Date value) {
            addCriterion("ENROLL_TIME =", value, "enrollTime");
            return (Criteria) this;
        }

        public Criteria andEnrollTimeNotEqualTo(Date value) {
            addCriterion("ENROLL_TIME <>", value, "enrollTime");
            return (Criteria) this;
        }

        public Criteria andEnrollTimeGreaterThan(Date value) {
            addCriterion("ENROLL_TIME >", value, "enrollTime");
            return (Criteria) this;
        }

        public Criteria andEnrollTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ENROLL_TIME >=", value, "enrollTime");
            return (Criteria) this;
        }

        public Criteria andEnrollTimeLessThan(Date value) {
            addCriterion("ENROLL_TIME <", value, "enrollTime");
            return (Criteria) this;
        }

        public Criteria andEnrollTimeLessThanOrEqualTo(Date value) {
            addCriterion("ENROLL_TIME <=", value, "enrollTime");
            return (Criteria) this;
        }

        public Criteria andEnrollTimeIn(List<Date> values) {
            addCriterion("ENROLL_TIME in", values, "enrollTime");
            return (Criteria) this;
        }

        public Criteria andEnrollTimeNotIn(List<Date> values) {
            addCriterion("ENROLL_TIME not in", values, "enrollTime");
            return (Criteria) this;
        }

        public Criteria andEnrollTimeBetween(Date value1, Date value2) {
            addCriterion("ENROLL_TIME between", value1, value2, "enrollTime");
            return (Criteria) this;
        }

        public Criteria andEnrollTimeNotBetween(Date value1, Date value2) {
            addCriterion("ENROLL_TIME not between", value1, value2, "enrollTime");
            return (Criteria) this;
        }

        public Criteria andEmployOrNotIsNull() {
            addCriterion("EMPLOY_OR_NOT is null");
            return (Criteria) this;
        }

        public Criteria andEmployOrNotIsNotNull() {
            addCriterion("EMPLOY_OR_NOT is not null");
            return (Criteria) this;
        }

        public Criteria andEmployOrNotEqualTo(String value) {
            addCriterion("EMPLOY_OR_NOT =", value, "employOrNot");
            return (Criteria) this;
        }

        public Criteria andEmployOrNotNotEqualTo(String value) {
            addCriterion("EMPLOY_OR_NOT <>", value, "employOrNot");
            return (Criteria) this;
        }

        public Criteria andEmployOrNotGreaterThan(String value) {
            addCriterion("EMPLOY_OR_NOT >", value, "employOrNot");
            return (Criteria) this;
        }

        public Criteria andEmployOrNotGreaterThanOrEqualTo(String value) {
            addCriterion("EMPLOY_OR_NOT >=", value, "employOrNot");
            return (Criteria) this;
        }

        public Criteria andEmployOrNotLessThan(String value) {
            addCriterion("EMPLOY_OR_NOT <", value, "employOrNot");
            return (Criteria) this;
        }

        public Criteria andEmployOrNotLessThanOrEqualTo(String value) {
            addCriterion("EMPLOY_OR_NOT <=", value, "employOrNot");
            return (Criteria) this;
        }

        public Criteria andEmployOrNotLike(String value) {
            addCriterion("EMPLOY_OR_NOT like", value, "employOrNot");
            return (Criteria) this;
        }

        public Criteria andEmployOrNotNotLike(String value) {
            addCriterion("EMPLOY_OR_NOT not like", value, "employOrNot");
            return (Criteria) this;
        }

        public Criteria andEmployOrNotIn(List<String> values) {
            addCriterion("EMPLOY_OR_NOT in", values, "employOrNot");
            return (Criteria) this;
        }

        public Criteria andEmployOrNotNotIn(List<String> values) {
            addCriterion("EMPLOY_OR_NOT not in", values, "employOrNot");
            return (Criteria) this;
        }

        public Criteria andEmployOrNotBetween(String value1, String value2) {
            addCriterion("EMPLOY_OR_NOT between", value1, value2, "employOrNot");
            return (Criteria) this;
        }

        public Criteria andEmployOrNotNotBetween(String value1, String value2) {
            addCriterion("EMPLOY_OR_NOT not between", value1, value2, "employOrNot");
            return (Criteria) this;
        }

        public Criteria andVolunteerRemarksIsNull() {
            addCriterion("VOLUNTEER_REMARKS is null");
            return (Criteria) this;
        }

        public Criteria andVolunteerRemarksIsNotNull() {
            addCriterion("VOLUNTEER_REMARKS is not null");
            return (Criteria) this;
        }

        public Criteria andVolunteerRemarksEqualTo(String value) {
            addCriterion("VOLUNTEER_REMARKS =", value, "volunteerRemarks");
            return (Criteria) this;
        }

        public Criteria andVolunteerRemarksNotEqualTo(String value) {
            addCriterion("VOLUNTEER_REMARKS <>", value, "volunteerRemarks");
            return (Criteria) this;
        }

        public Criteria andVolunteerRemarksGreaterThan(String value) {
            addCriterion("VOLUNTEER_REMARKS >", value, "volunteerRemarks");
            return (Criteria) this;
        }

        public Criteria andVolunteerRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("VOLUNTEER_REMARKS >=", value, "volunteerRemarks");
            return (Criteria) this;
        }

        public Criteria andVolunteerRemarksLessThan(String value) {
            addCriterion("VOLUNTEER_REMARKS <", value, "volunteerRemarks");
            return (Criteria) this;
        }

        public Criteria andVolunteerRemarksLessThanOrEqualTo(String value) {
            addCriterion("VOLUNTEER_REMARKS <=", value, "volunteerRemarks");
            return (Criteria) this;
        }

        public Criteria andVolunteerRemarksLike(String value) {
            addCriterion("VOLUNTEER_REMARKS like", value, "volunteerRemarks");
            return (Criteria) this;
        }

        public Criteria andVolunteerRemarksNotLike(String value) {
            addCriterion("VOLUNTEER_REMARKS not like", value, "volunteerRemarks");
            return (Criteria) this;
        }

        public Criteria andVolunteerRemarksIn(List<String> values) {
            addCriterion("VOLUNTEER_REMARKS in", values, "volunteerRemarks");
            return (Criteria) this;
        }

        public Criteria andVolunteerRemarksNotIn(List<String> values) {
            addCriterion("VOLUNTEER_REMARKS not in", values, "volunteerRemarks");
            return (Criteria) this;
        }

        public Criteria andVolunteerRemarksBetween(String value1, String value2) {
            addCriterion("VOLUNTEER_REMARKS between", value1, value2, "volunteerRemarks");
            return (Criteria) this;
        }

        public Criteria andVolunteerRemarksNotBetween(String value1, String value2) {
            addCriterion("VOLUNTEER_REMARKS not between", value1, value2, "volunteerRemarks");
            return (Criteria) this;
        }

        public Criteria andSponsorRemarksIsNull() {
            addCriterion("SPONSOR_REMARKS is null");
            return (Criteria) this;
        }

        public Criteria andSponsorRemarksIsNotNull() {
            addCriterion("SPONSOR_REMARKS is not null");
            return (Criteria) this;
        }

        public Criteria andSponsorRemarksEqualTo(String value) {
            addCriterion("SPONSOR_REMARKS =", value, "sponsorRemarks");
            return (Criteria) this;
        }

        public Criteria andSponsorRemarksNotEqualTo(String value) {
            addCriterion("SPONSOR_REMARKS <>", value, "sponsorRemarks");
            return (Criteria) this;
        }

        public Criteria andSponsorRemarksGreaterThan(String value) {
            addCriterion("SPONSOR_REMARKS >", value, "sponsorRemarks");
            return (Criteria) this;
        }

        public Criteria andSponsorRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("SPONSOR_REMARKS >=", value, "sponsorRemarks");
            return (Criteria) this;
        }

        public Criteria andSponsorRemarksLessThan(String value) {
            addCriterion("SPONSOR_REMARKS <", value, "sponsorRemarks");
            return (Criteria) this;
        }

        public Criteria andSponsorRemarksLessThanOrEqualTo(String value) {
            addCriterion("SPONSOR_REMARKS <=", value, "sponsorRemarks");
            return (Criteria) this;
        }

        public Criteria andSponsorRemarksLike(String value) {
            addCriterion("SPONSOR_REMARKS like", value, "sponsorRemarks");
            return (Criteria) this;
        }

        public Criteria andSponsorRemarksNotLike(String value) {
            addCriterion("SPONSOR_REMARKS not like", value, "sponsorRemarks");
            return (Criteria) this;
        }

        public Criteria andSponsorRemarksIn(List<String> values) {
            addCriterion("SPONSOR_REMARKS in", values, "sponsorRemarks");
            return (Criteria) this;
        }

        public Criteria andSponsorRemarksNotIn(List<String> values) {
            addCriterion("SPONSOR_REMARKS not in", values, "sponsorRemarks");
            return (Criteria) this;
        }

        public Criteria andSponsorRemarksBetween(String value1, String value2) {
            addCriterion("SPONSOR_REMARKS between", value1, value2, "sponsorRemarks");
            return (Criteria) this;
        }

        public Criteria andSponsorRemarksNotBetween(String value1, String value2) {
            addCriterion("SPONSOR_REMARKS not between", value1, value2, "sponsorRemarks");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}