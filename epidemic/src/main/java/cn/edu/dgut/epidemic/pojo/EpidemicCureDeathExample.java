package cn.edu.dgut.epidemic.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EpidemicCureDeathExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EpidemicCureDeathExample() {
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

        public Criteria andEpidemicCureIdIsNull() {
            addCriterion("EPIDEMIC_CURE_ID is null");
            return (Criteria) this;
        }

        public Criteria andEpidemicCureIdIsNotNull() {
            addCriterion("EPIDEMIC_CURE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEpidemicCureIdEqualTo(Integer value) {
            addCriterion("EPIDEMIC_CURE_ID =", value, "epidemicCureId");
            return (Criteria) this;
        }

        public Criteria andEpidemicCureIdNotEqualTo(Integer value) {
            addCriterion("EPIDEMIC_CURE_ID <>", value, "epidemicCureId");
            return (Criteria) this;
        }

        public Criteria andEpidemicCureIdGreaterThan(Integer value) {
            addCriterion("EPIDEMIC_CURE_ID >", value, "epidemicCureId");
            return (Criteria) this;
        }

        public Criteria andEpidemicCureIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("EPIDEMIC_CURE_ID >=", value, "epidemicCureId");
            return (Criteria) this;
        }

        public Criteria andEpidemicCureIdLessThan(Integer value) {
            addCriterion("EPIDEMIC_CURE_ID <", value, "epidemicCureId");
            return (Criteria) this;
        }

        public Criteria andEpidemicCureIdLessThanOrEqualTo(Integer value) {
            addCriterion("EPIDEMIC_CURE_ID <=", value, "epidemicCureId");
            return (Criteria) this;
        }

        public Criteria andEpidemicCureIdIn(List<Integer> values) {
            addCriterion("EPIDEMIC_CURE_ID in", values, "epidemicCureId");
            return (Criteria) this;
        }

        public Criteria andEpidemicCureIdNotIn(List<Integer> values) {
            addCriterion("EPIDEMIC_CURE_ID not in", values, "epidemicCureId");
            return (Criteria) this;
        }

        public Criteria andEpidemicCureIdBetween(Integer value1, Integer value2) {
            addCriterion("EPIDEMIC_CURE_ID between", value1, value2, "epidemicCureId");
            return (Criteria) this;
        }

        public Criteria andEpidemicCureIdNotBetween(Integer value1, Integer value2) {
            addCriterion("EPIDEMIC_CURE_ID not between", value1, value2, "epidemicCureId");
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

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andTimeOfCureIsNull() {
            addCriterion("TIME_OF_CURE is null");
            return (Criteria) this;
        }

        public Criteria andTimeOfCureIsNotNull() {
            addCriterion("TIME_OF_CURE is not null");
            return (Criteria) this;
        }

        public Criteria andTimeOfCureEqualTo(Date value) {
            addCriterion("TIME_OF_CURE =", value, "timeOfCure");
            return (Criteria) this;
        }

        public Criteria andTimeOfCureNotEqualTo(Date value) {
            addCriterion("TIME_OF_CURE <>", value, "timeOfCure");
            return (Criteria) this;
        }

        public Criteria andTimeOfCureGreaterThan(Date value) {
            addCriterion("TIME_OF_CURE >", value, "timeOfCure");
            return (Criteria) this;
        }

        public Criteria andTimeOfCureGreaterThanOrEqualTo(Date value) {
            addCriterion("TIME_OF_CURE >=", value, "timeOfCure");
            return (Criteria) this;
        }

        public Criteria andTimeOfCureLessThan(Date value) {
            addCriterion("TIME_OF_CURE <", value, "timeOfCure");
            return (Criteria) this;
        }

        public Criteria andTimeOfCureLessThanOrEqualTo(Date value) {
            addCriterion("TIME_OF_CURE <=", value, "timeOfCure");
            return (Criteria) this;
        }

        public Criteria andTimeOfCureIn(List<Date> values) {
            addCriterion("TIME_OF_CURE in", values, "timeOfCure");
            return (Criteria) this;
        }

        public Criteria andTimeOfCureNotIn(List<Date> values) {
            addCriterion("TIME_OF_CURE not in", values, "timeOfCure");
            return (Criteria) this;
        }

        public Criteria andTimeOfCureBetween(Date value1, Date value2) {
            addCriterion("TIME_OF_CURE between", value1, value2, "timeOfCure");
            return (Criteria) this;
        }

        public Criteria andTimeOfCureNotBetween(Date value1, Date value2) {
            addCriterion("TIME_OF_CURE not between", value1, value2, "timeOfCure");
            return (Criteria) this;
        }

        public Criteria andTimeOfDeathIsNull() {
            addCriterion("TIME_OF_DEATH is null");
            return (Criteria) this;
        }

        public Criteria andTimeOfDeathIsNotNull() {
            addCriterion("TIME_OF_DEATH is not null");
            return (Criteria) this;
        }

        public Criteria andTimeOfDeathEqualTo(Date value) {
            addCriterion("TIME_OF_DEATH =", value, "timeOfDeath");
            return (Criteria) this;
        }

        public Criteria andTimeOfDeathNotEqualTo(Date value) {
            addCriterion("TIME_OF_DEATH <>", value, "timeOfDeath");
            return (Criteria) this;
        }

        public Criteria andTimeOfDeathGreaterThan(Date value) {
            addCriterion("TIME_OF_DEATH >", value, "timeOfDeath");
            return (Criteria) this;
        }

        public Criteria andTimeOfDeathGreaterThanOrEqualTo(Date value) {
            addCriterion("TIME_OF_DEATH >=", value, "timeOfDeath");
            return (Criteria) this;
        }

        public Criteria andTimeOfDeathLessThan(Date value) {
            addCriterion("TIME_OF_DEATH <", value, "timeOfDeath");
            return (Criteria) this;
        }

        public Criteria andTimeOfDeathLessThanOrEqualTo(Date value) {
            addCriterion("TIME_OF_DEATH <=", value, "timeOfDeath");
            return (Criteria) this;
        }

        public Criteria andTimeOfDeathIn(List<Date> values) {
            addCriterion("TIME_OF_DEATH in", values, "timeOfDeath");
            return (Criteria) this;
        }

        public Criteria andTimeOfDeathNotIn(List<Date> values) {
            addCriterion("TIME_OF_DEATH not in", values, "timeOfDeath");
            return (Criteria) this;
        }

        public Criteria andTimeOfDeathBetween(Date value1, Date value2) {
            addCriterion("TIME_OF_DEATH between", value1, value2, "timeOfDeath");
            return (Criteria) this;
        }

        public Criteria andTimeOfDeathNotBetween(Date value1, Date value2) {
            addCriterion("TIME_OF_DEATH not between", value1, value2, "timeOfDeath");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("REMARKS is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("REMARKS is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("REMARKS =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("REMARKS <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("REMARKS >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("REMARKS >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("REMARKS <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("REMARKS <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("REMARKS like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("REMARKS not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("REMARKS in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("REMARKS not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("REMARKS between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("REMARKS not between", value1, value2, "remarks");
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