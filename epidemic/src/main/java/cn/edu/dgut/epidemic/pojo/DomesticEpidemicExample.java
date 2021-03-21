package cn.edu.dgut.epidemic.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DomesticEpidemicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DomesticEpidemicExample() {
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

        public Criteria andEpidemicIdIsNull() {
            addCriterion("EPIDEMIC_ID is null");
            return (Criteria) this;
        }

        public Criteria andEpidemicIdIsNotNull() {
            addCriterion("EPIDEMIC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEpidemicIdEqualTo(Short value) {
            addCriterion("EPIDEMIC_ID =", value, "epidemicId");
            return (Criteria) this;
        }

        public Criteria andEpidemicIdNotEqualTo(Short value) {
            addCriterion("EPIDEMIC_ID <>", value, "epidemicId");
            return (Criteria) this;
        }

        public Criteria andEpidemicIdGreaterThan(Short value) {
            addCriterion("EPIDEMIC_ID >", value, "epidemicId");
            return (Criteria) this;
        }

        public Criteria andEpidemicIdGreaterThanOrEqualTo(Short value) {
            addCriterion("EPIDEMIC_ID >=", value, "epidemicId");
            return (Criteria) this;
        }

        public Criteria andEpidemicIdLessThan(Short value) {
            addCriterion("EPIDEMIC_ID <", value, "epidemicId");
            return (Criteria) this;
        }

        public Criteria andEpidemicIdLessThanOrEqualTo(Short value) {
            addCriterion("EPIDEMIC_ID <=", value, "epidemicId");
            return (Criteria) this;
        }

        public Criteria andEpidemicIdIn(List<Short> values) {
            addCriterion("EPIDEMIC_ID in", values, "epidemicId");
            return (Criteria) this;
        }

        public Criteria andEpidemicIdNotIn(List<Short> values) {
            addCriterion("EPIDEMIC_ID not in", values, "epidemicId");
            return (Criteria) this;
        }

        public Criteria andEpidemicIdBetween(Short value1, Short value2) {
            addCriterion("EPIDEMIC_ID between", value1, value2, "epidemicId");
            return (Criteria) this;
        }

        public Criteria andEpidemicIdNotBetween(Short value1, Short value2) {
            addCriterion("EPIDEMIC_ID not between", value1, value2, "epidemicId");
            return (Criteria) this;
        }

        public Criteria andExistingDiagnosisIsNull() {
            addCriterion("EXISTING_DIAGNOSIS is null");
            return (Criteria) this;
        }

        public Criteria andExistingDiagnosisIsNotNull() {
            addCriterion("EXISTING_DIAGNOSIS is not null");
            return (Criteria) this;
        }

        public Criteria andExistingDiagnosisEqualTo(Integer value) {
            addCriterion("EXISTING_DIAGNOSIS =", value, "existingDiagnosis");
            return (Criteria) this;
        }

        public Criteria andExistingDiagnosisNotEqualTo(Integer value) {
            addCriterion("EXISTING_DIAGNOSIS <>", value, "existingDiagnosis");
            return (Criteria) this;
        }

        public Criteria andExistingDiagnosisGreaterThan(Integer value) {
            addCriterion("EXISTING_DIAGNOSIS >", value, "existingDiagnosis");
            return (Criteria) this;
        }

        public Criteria andExistingDiagnosisGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXISTING_DIAGNOSIS >=", value, "existingDiagnosis");
            return (Criteria) this;
        }

        public Criteria andExistingDiagnosisLessThan(Integer value) {
            addCriterion("EXISTING_DIAGNOSIS <", value, "existingDiagnosis");
            return (Criteria) this;
        }

        public Criteria andExistingDiagnosisLessThanOrEqualTo(Integer value) {
            addCriterion("EXISTING_DIAGNOSIS <=", value, "existingDiagnosis");
            return (Criteria) this;
        }

        public Criteria andExistingDiagnosisIn(List<Integer> values) {
            addCriterion("EXISTING_DIAGNOSIS in", values, "existingDiagnosis");
            return (Criteria) this;
        }

        public Criteria andExistingDiagnosisNotIn(List<Integer> values) {
            addCriterion("EXISTING_DIAGNOSIS not in", values, "existingDiagnosis");
            return (Criteria) this;
        }

        public Criteria andExistingDiagnosisBetween(Integer value1, Integer value2) {
            addCriterion("EXISTING_DIAGNOSIS between", value1, value2, "existingDiagnosis");
            return (Criteria) this;
        }

        public Criteria andExistingDiagnosisNotBetween(Integer value1, Integer value2) {
            addCriterion("EXISTING_DIAGNOSIS not between", value1, value2, "existingDiagnosis");
            return (Criteria) this;
        }

        public Criteria andCumulativeDiagnosisIsNull() {
            addCriterion("CUMULATIVE_DIAGNOSIS is null");
            return (Criteria) this;
        }

        public Criteria andCumulativeDiagnosisIsNotNull() {
            addCriterion("CUMULATIVE_DIAGNOSIS is not null");
            return (Criteria) this;
        }

        public Criteria andCumulativeDiagnosisEqualTo(Integer value) {
            addCriterion("CUMULATIVE_DIAGNOSIS =", value, "cumulativeDiagnosis");
            return (Criteria) this;
        }

        public Criteria andCumulativeDiagnosisNotEqualTo(Integer value) {
            addCriterion("CUMULATIVE_DIAGNOSIS <>", value, "cumulativeDiagnosis");
            return (Criteria) this;
        }

        public Criteria andCumulativeDiagnosisGreaterThan(Integer value) {
            addCriterion("CUMULATIVE_DIAGNOSIS >", value, "cumulativeDiagnosis");
            return (Criteria) this;
        }

        public Criteria andCumulativeDiagnosisGreaterThanOrEqualTo(Integer value) {
            addCriterion("CUMULATIVE_DIAGNOSIS >=", value, "cumulativeDiagnosis");
            return (Criteria) this;
        }

        public Criteria andCumulativeDiagnosisLessThan(Integer value) {
            addCriterion("CUMULATIVE_DIAGNOSIS <", value, "cumulativeDiagnosis");
            return (Criteria) this;
        }

        public Criteria andCumulativeDiagnosisLessThanOrEqualTo(Integer value) {
            addCriterion("CUMULATIVE_DIAGNOSIS <=", value, "cumulativeDiagnosis");
            return (Criteria) this;
        }

        public Criteria andCumulativeDiagnosisIn(List<Integer> values) {
            addCriterion("CUMULATIVE_DIAGNOSIS in", values, "cumulativeDiagnosis");
            return (Criteria) this;
        }

        public Criteria andCumulativeDiagnosisNotIn(List<Integer> values) {
            addCriterion("CUMULATIVE_DIAGNOSIS not in", values, "cumulativeDiagnosis");
            return (Criteria) this;
        }

        public Criteria andCumulativeDiagnosisBetween(Integer value1, Integer value2) {
            addCriterion("CUMULATIVE_DIAGNOSIS between", value1, value2, "cumulativeDiagnosis");
            return (Criteria) this;
        }

        public Criteria andCumulativeDiagnosisNotBetween(Integer value1, Integer value2) {
            addCriterion("CUMULATIVE_DIAGNOSIS not between", value1, value2, "cumulativeDiagnosis");
            return (Criteria) this;
        }

        public Criteria andOverseasInputIsNull() {
            addCriterion("OVERSEAS_INPUT is null");
            return (Criteria) this;
        }

        public Criteria andOverseasInputIsNotNull() {
            addCriterion("OVERSEAS_INPUT is not null");
            return (Criteria) this;
        }

        public Criteria andOverseasInputEqualTo(Integer value) {
            addCriterion("OVERSEAS_INPUT =", value, "overseasInput");
            return (Criteria) this;
        }

        public Criteria andOverseasInputNotEqualTo(Integer value) {
            addCriterion("OVERSEAS_INPUT <>", value, "overseasInput");
            return (Criteria) this;
        }

        public Criteria andOverseasInputGreaterThan(Integer value) {
            addCriterion("OVERSEAS_INPUT >", value, "overseasInput");
            return (Criteria) this;
        }

        public Criteria andOverseasInputGreaterThanOrEqualTo(Integer value) {
            addCriterion("OVERSEAS_INPUT >=", value, "overseasInput");
            return (Criteria) this;
        }

        public Criteria andOverseasInputLessThan(Integer value) {
            addCriterion("OVERSEAS_INPUT <", value, "overseasInput");
            return (Criteria) this;
        }

        public Criteria andOverseasInputLessThanOrEqualTo(Integer value) {
            addCriterion("OVERSEAS_INPUT <=", value, "overseasInput");
            return (Criteria) this;
        }

        public Criteria andOverseasInputIn(List<Integer> values) {
            addCriterion("OVERSEAS_INPUT in", values, "overseasInput");
            return (Criteria) this;
        }

        public Criteria andOverseasInputNotIn(List<Integer> values) {
            addCriterion("OVERSEAS_INPUT not in", values, "overseasInput");
            return (Criteria) this;
        }

        public Criteria andOverseasInputBetween(Integer value1, Integer value2) {
            addCriterion("OVERSEAS_INPUT between", value1, value2, "overseasInput");
            return (Criteria) this;
        }

        public Criteria andOverseasInputNotBetween(Integer value1, Integer value2) {
            addCriterion("OVERSEAS_INPUT not between", value1, value2, "overseasInput");
            return (Criteria) this;
        }

        public Criteria andExistingAsymptomaticIsNull() {
            addCriterion("EXISTING_ASYMPTOMATIC is null");
            return (Criteria) this;
        }

        public Criteria andExistingAsymptomaticIsNotNull() {
            addCriterion("EXISTING_ASYMPTOMATIC is not null");
            return (Criteria) this;
        }

        public Criteria andExistingAsymptomaticEqualTo(Integer value) {
            addCriterion("EXISTING_ASYMPTOMATIC =", value, "existingAsymptomatic");
            return (Criteria) this;
        }

        public Criteria andExistingAsymptomaticNotEqualTo(Integer value) {
            addCriterion("EXISTING_ASYMPTOMATIC <>", value, "existingAsymptomatic");
            return (Criteria) this;
        }

        public Criteria andExistingAsymptomaticGreaterThan(Integer value) {
            addCriterion("EXISTING_ASYMPTOMATIC >", value, "existingAsymptomatic");
            return (Criteria) this;
        }

        public Criteria andExistingAsymptomaticGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXISTING_ASYMPTOMATIC >=", value, "existingAsymptomatic");
            return (Criteria) this;
        }

        public Criteria andExistingAsymptomaticLessThan(Integer value) {
            addCriterion("EXISTING_ASYMPTOMATIC <", value, "existingAsymptomatic");
            return (Criteria) this;
        }

        public Criteria andExistingAsymptomaticLessThanOrEqualTo(Integer value) {
            addCriterion("EXISTING_ASYMPTOMATIC <=", value, "existingAsymptomatic");
            return (Criteria) this;
        }

        public Criteria andExistingAsymptomaticIn(List<Integer> values) {
            addCriterion("EXISTING_ASYMPTOMATIC in", values, "existingAsymptomatic");
            return (Criteria) this;
        }

        public Criteria andExistingAsymptomaticNotIn(List<Integer> values) {
            addCriterion("EXISTING_ASYMPTOMATIC not in", values, "existingAsymptomatic");
            return (Criteria) this;
        }

        public Criteria andExistingAsymptomaticBetween(Integer value1, Integer value2) {
            addCriterion("EXISTING_ASYMPTOMATIC between", value1, value2, "existingAsymptomatic");
            return (Criteria) this;
        }

        public Criteria andExistingAsymptomaticNotBetween(Integer value1, Integer value2) {
            addCriterion("EXISTING_ASYMPTOMATIC not between", value1, value2, "existingAsymptomatic");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeathIsNull() {
            addCriterion("CUMULATIVE_DEATH is null");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeathIsNotNull() {
            addCriterion("CUMULATIVE_DEATH is not null");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeathEqualTo(Integer value) {
            addCriterion("CUMULATIVE_DEATH =", value, "cumulativeDeath");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeathNotEqualTo(Integer value) {
            addCriterion("CUMULATIVE_DEATH <>", value, "cumulativeDeath");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeathGreaterThan(Integer value) {
            addCriterion("CUMULATIVE_DEATH >", value, "cumulativeDeath");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeathGreaterThanOrEqualTo(Integer value) {
            addCriterion("CUMULATIVE_DEATH >=", value, "cumulativeDeath");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeathLessThan(Integer value) {
            addCriterion("CUMULATIVE_DEATH <", value, "cumulativeDeath");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeathLessThanOrEqualTo(Integer value) {
            addCriterion("CUMULATIVE_DEATH <=", value, "cumulativeDeath");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeathIn(List<Integer> values) {
            addCriterion("CUMULATIVE_DEATH in", values, "cumulativeDeath");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeathNotIn(List<Integer> values) {
            addCriterion("CUMULATIVE_DEATH not in", values, "cumulativeDeath");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeathBetween(Integer value1, Integer value2) {
            addCriterion("CUMULATIVE_DEATH between", value1, value2, "cumulativeDeath");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeathNotBetween(Integer value1, Integer value2) {
            addCriterion("CUMULATIVE_DEATH not between", value1, value2, "cumulativeDeath");
            return (Criteria) this;
        }

        public Criteria andCumulativeCureIsNull() {
            addCriterion("CUMULATIVE_CURE is null");
            return (Criteria) this;
        }

        public Criteria andCumulativeCureIsNotNull() {
            addCriterion("CUMULATIVE_CURE is not null");
            return (Criteria) this;
        }

        public Criteria andCumulativeCureEqualTo(Integer value) {
            addCriterion("CUMULATIVE_CURE =", value, "cumulativeCure");
            return (Criteria) this;
        }

        public Criteria andCumulativeCureNotEqualTo(Integer value) {
            addCriterion("CUMULATIVE_CURE <>", value, "cumulativeCure");
            return (Criteria) this;
        }

        public Criteria andCumulativeCureGreaterThan(Integer value) {
            addCriterion("CUMULATIVE_CURE >", value, "cumulativeCure");
            return (Criteria) this;
        }

        public Criteria andCumulativeCureGreaterThanOrEqualTo(Integer value) {
            addCriterion("CUMULATIVE_CURE >=", value, "cumulativeCure");
            return (Criteria) this;
        }

        public Criteria andCumulativeCureLessThan(Integer value) {
            addCriterion("CUMULATIVE_CURE <", value, "cumulativeCure");
            return (Criteria) this;
        }

        public Criteria andCumulativeCureLessThanOrEqualTo(Integer value) {
            addCriterion("CUMULATIVE_CURE <=", value, "cumulativeCure");
            return (Criteria) this;
        }

        public Criteria andCumulativeCureIn(List<Integer> values) {
            addCriterion("CUMULATIVE_CURE in", values, "cumulativeCure");
            return (Criteria) this;
        }

        public Criteria andCumulativeCureNotIn(List<Integer> values) {
            addCriterion("CUMULATIVE_CURE not in", values, "cumulativeCure");
            return (Criteria) this;
        }

        public Criteria andCumulativeCureBetween(Integer value1, Integer value2) {
            addCriterion("CUMULATIVE_CURE between", value1, value2, "cumulativeCure");
            return (Criteria) this;
        }

        public Criteria andCumulativeCureNotBetween(Integer value1, Integer value2) {
            addCriterion("CUMULATIVE_CURE not between", value1, value2, "cumulativeCure");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
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