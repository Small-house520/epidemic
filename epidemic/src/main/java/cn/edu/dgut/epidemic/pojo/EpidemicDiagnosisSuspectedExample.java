package cn.edu.dgut.epidemic.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EpidemicDiagnosisSuspectedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EpidemicDiagnosisSuspectedExample() {
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

        public Criteria andSymptomsIsNull() {
            addCriterion("SYMPTOMS is null");
            return (Criteria) this;
        }

        public Criteria andSymptomsIsNotNull() {
            addCriterion("SYMPTOMS is not null");
            return (Criteria) this;
        }

        public Criteria andSymptomsEqualTo(String value) {
            addCriterion("SYMPTOMS =", value, "symptoms");
            return (Criteria) this;
        }

        public Criteria andSymptomsNotEqualTo(String value) {
            addCriterion("SYMPTOMS <>", value, "symptoms");
            return (Criteria) this;
        }

        public Criteria andSymptomsGreaterThan(String value) {
            addCriterion("SYMPTOMS >", value, "symptoms");
            return (Criteria) this;
        }

        public Criteria andSymptomsGreaterThanOrEqualTo(String value) {
            addCriterion("SYMPTOMS >=", value, "symptoms");
            return (Criteria) this;
        }

        public Criteria andSymptomsLessThan(String value) {
            addCriterion("SYMPTOMS <", value, "symptoms");
            return (Criteria) this;
        }

        public Criteria andSymptomsLessThanOrEqualTo(String value) {
            addCriterion("SYMPTOMS <=", value, "symptoms");
            return (Criteria) this;
        }

        public Criteria andSymptomsLike(String value) {
            addCriterion("SYMPTOMS like", value, "symptoms");
            return (Criteria) this;
        }

        public Criteria andSymptomsNotLike(String value) {
            addCriterion("SYMPTOMS not like", value, "symptoms");
            return (Criteria) this;
        }

        public Criteria andSymptomsIn(List<String> values) {
            addCriterion("SYMPTOMS in", values, "symptoms");
            return (Criteria) this;
        }

        public Criteria andSymptomsNotIn(List<String> values) {
            addCriterion("SYMPTOMS not in", values, "symptoms");
            return (Criteria) this;
        }

        public Criteria andSymptomsBetween(String value1, String value2) {
            addCriterion("SYMPTOMS between", value1, value2, "symptoms");
            return (Criteria) this;
        }

        public Criteria andSymptomsNotBetween(String value1, String value2) {
            addCriterion("SYMPTOMS not between", value1, value2, "symptoms");
            return (Criteria) this;
        }

        public Criteria andHospitalIsNull() {
            addCriterion("HOSPITAL is null");
            return (Criteria) this;
        }

        public Criteria andHospitalIsNotNull() {
            addCriterion("HOSPITAL is not null");
            return (Criteria) this;
        }

        public Criteria andHospitalEqualTo(String value) {
            addCriterion("HOSPITAL =", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalNotEqualTo(String value) {
            addCriterion("HOSPITAL <>", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalGreaterThan(String value) {
            addCriterion("HOSPITAL >", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalGreaterThanOrEqualTo(String value) {
            addCriterion("HOSPITAL >=", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalLessThan(String value) {
            addCriterion("HOSPITAL <", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalLessThanOrEqualTo(String value) {
            addCriterion("HOSPITAL <=", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalLike(String value) {
            addCriterion("HOSPITAL like", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalNotLike(String value) {
            addCriterion("HOSPITAL not like", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalIn(List<String> values) {
            addCriterion("HOSPITAL in", values, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalNotIn(List<String> values) {
            addCriterion("HOSPITAL not in", values, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalBetween(String value1, String value2) {
            addCriterion("HOSPITAL between", value1, value2, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalNotBetween(String value1, String value2) {
            addCriterion("HOSPITAL not between", value1, value2, "hospital");
            return (Criteria) this;
        }

        public Criteria andLengthOfStayIsNull() {
            addCriterion("LENGTH_OF_STAY is null");
            return (Criteria) this;
        }

        public Criteria andLengthOfStayIsNotNull() {
            addCriterion("LENGTH_OF_STAY is not null");
            return (Criteria) this;
        }

        public Criteria andLengthOfStayEqualTo(Date value) {
            addCriterion("LENGTH_OF_STAY =", value, "lengthOfStay");
            return (Criteria) this;
        }

        public Criteria andLengthOfStayNotEqualTo(Date value) {
            addCriterion("LENGTH_OF_STAY <>", value, "lengthOfStay");
            return (Criteria) this;
        }

        public Criteria andLengthOfStayGreaterThan(Date value) {
            addCriterion("LENGTH_OF_STAY >", value, "lengthOfStay");
            return (Criteria) this;
        }

        public Criteria andLengthOfStayGreaterThanOrEqualTo(Date value) {
            addCriterion("LENGTH_OF_STAY >=", value, "lengthOfStay");
            return (Criteria) this;
        }

        public Criteria andLengthOfStayLessThan(Date value) {
            addCriterion("LENGTH_OF_STAY <", value, "lengthOfStay");
            return (Criteria) this;
        }

        public Criteria andLengthOfStayLessThanOrEqualTo(Date value) {
            addCriterion("LENGTH_OF_STAY <=", value, "lengthOfStay");
            return (Criteria) this;
        }

        public Criteria andLengthOfStayIn(List<Date> values) {
            addCriterion("LENGTH_OF_STAY in", values, "lengthOfStay");
            return (Criteria) this;
        }

        public Criteria andLengthOfStayNotIn(List<Date> values) {
            addCriterion("LENGTH_OF_STAY not in", values, "lengthOfStay");
            return (Criteria) this;
        }

        public Criteria andLengthOfStayBetween(Date value1, Date value2) {
            addCriterion("LENGTH_OF_STAY between", value1, value2, "lengthOfStay");
            return (Criteria) this;
        }

        public Criteria andLengthOfStayNotBetween(Date value1, Date value2) {
            addCriterion("LENGTH_OF_STAY not between", value1, value2, "lengthOfStay");
            return (Criteria) this;
        }

        public Criteria andSourceOfInfectionIsNull() {
            addCriterion("SOURCE_OF_INFECTION is null");
            return (Criteria) this;
        }

        public Criteria andSourceOfInfectionIsNotNull() {
            addCriterion("SOURCE_OF_INFECTION is not null");
            return (Criteria) this;
        }

        public Criteria andSourceOfInfectionEqualTo(String value) {
            addCriterion("SOURCE_OF_INFECTION =", value, "sourceOfInfection");
            return (Criteria) this;
        }

        public Criteria andSourceOfInfectionNotEqualTo(String value) {
            addCriterion("SOURCE_OF_INFECTION <>", value, "sourceOfInfection");
            return (Criteria) this;
        }

        public Criteria andSourceOfInfectionGreaterThan(String value) {
            addCriterion("SOURCE_OF_INFECTION >", value, "sourceOfInfection");
            return (Criteria) this;
        }

        public Criteria andSourceOfInfectionGreaterThanOrEqualTo(String value) {
            addCriterion("SOURCE_OF_INFECTION >=", value, "sourceOfInfection");
            return (Criteria) this;
        }

        public Criteria andSourceOfInfectionLessThan(String value) {
            addCriterion("SOURCE_OF_INFECTION <", value, "sourceOfInfection");
            return (Criteria) this;
        }

        public Criteria andSourceOfInfectionLessThanOrEqualTo(String value) {
            addCriterion("SOURCE_OF_INFECTION <=", value, "sourceOfInfection");
            return (Criteria) this;
        }

        public Criteria andSourceOfInfectionLike(String value) {
            addCriterion("SOURCE_OF_INFECTION like", value, "sourceOfInfection");
            return (Criteria) this;
        }

        public Criteria andSourceOfInfectionNotLike(String value) {
            addCriterion("SOURCE_OF_INFECTION not like", value, "sourceOfInfection");
            return (Criteria) this;
        }

        public Criteria andSourceOfInfectionIn(List<String> values) {
            addCriterion("SOURCE_OF_INFECTION in", values, "sourceOfInfection");
            return (Criteria) this;
        }

        public Criteria andSourceOfInfectionNotIn(List<String> values) {
            addCriterion("SOURCE_OF_INFECTION not in", values, "sourceOfInfection");
            return (Criteria) this;
        }

        public Criteria andSourceOfInfectionBetween(String value1, String value2) {
            addCriterion("SOURCE_OF_INFECTION between", value1, value2, "sourceOfInfection");
            return (Criteria) this;
        }

        public Criteria andSourceOfInfectionNotBetween(String value1, String value2) {
            addCriterion("SOURCE_OF_INFECTION not between", value1, value2, "sourceOfInfection");
            return (Criteria) this;
        }

        public Criteria andWhetherDiagnosedIsNull() {
            addCriterion("WHETHER_DIAGNOSED is null");
            return (Criteria) this;
        }

        public Criteria andWhetherDiagnosedIsNotNull() {
            addCriterion("WHETHER_DIAGNOSED is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherDiagnosedEqualTo(String value) {
            addCriterion("WHETHER_DIAGNOSED =", value, "whetherDiagnosed");
            return (Criteria) this;
        }

        public Criteria andWhetherDiagnosedNotEqualTo(String value) {
            addCriterion("WHETHER_DIAGNOSED <>", value, "whetherDiagnosed");
            return (Criteria) this;
        }

        public Criteria andWhetherDiagnosedGreaterThan(String value) {
            addCriterion("WHETHER_DIAGNOSED >", value, "whetherDiagnosed");
            return (Criteria) this;
        }

        public Criteria andWhetherDiagnosedGreaterThanOrEqualTo(String value) {
            addCriterion("WHETHER_DIAGNOSED >=", value, "whetherDiagnosed");
            return (Criteria) this;
        }

        public Criteria andWhetherDiagnosedLessThan(String value) {
            addCriterion("WHETHER_DIAGNOSED <", value, "whetherDiagnosed");
            return (Criteria) this;
        }

        public Criteria andWhetherDiagnosedLessThanOrEqualTo(String value) {
            addCriterion("WHETHER_DIAGNOSED <=", value, "whetherDiagnosed");
            return (Criteria) this;
        }

        public Criteria andWhetherDiagnosedLike(String value) {
            addCriterion("WHETHER_DIAGNOSED like", value, "whetherDiagnosed");
            return (Criteria) this;
        }

        public Criteria andWhetherDiagnosedNotLike(String value) {
            addCriterion("WHETHER_DIAGNOSED not like", value, "whetherDiagnosed");
            return (Criteria) this;
        }

        public Criteria andWhetherDiagnosedIn(List<String> values) {
            addCriterion("WHETHER_DIAGNOSED in", values, "whetherDiagnosed");
            return (Criteria) this;
        }

        public Criteria andWhetherDiagnosedNotIn(List<String> values) {
            addCriterion("WHETHER_DIAGNOSED not in", values, "whetherDiagnosed");
            return (Criteria) this;
        }

        public Criteria andWhetherDiagnosedBetween(String value1, String value2) {
            addCriterion("WHETHER_DIAGNOSED between", value1, value2, "whetherDiagnosed");
            return (Criteria) this;
        }

        public Criteria andWhetherDiagnosedNotBetween(String value1, String value2) {
            addCriterion("WHETHER_DIAGNOSED not between", value1, value2, "whetherDiagnosed");
            return (Criteria) this;
        }

        public Criteria andWhetherSevereIsNull() {
            addCriterion("WHETHER_SEVERE is null");
            return (Criteria) this;
        }

        public Criteria andWhetherSevereIsNotNull() {
            addCriterion("WHETHER_SEVERE is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherSevereEqualTo(String value) {
            addCriterion("WHETHER_SEVERE =", value, "whetherSevere");
            return (Criteria) this;
        }

        public Criteria andWhetherSevereNotEqualTo(String value) {
            addCriterion("WHETHER_SEVERE <>", value, "whetherSevere");
            return (Criteria) this;
        }

        public Criteria andWhetherSevereGreaterThan(String value) {
            addCriterion("WHETHER_SEVERE >", value, "whetherSevere");
            return (Criteria) this;
        }

        public Criteria andWhetherSevereGreaterThanOrEqualTo(String value) {
            addCriterion("WHETHER_SEVERE >=", value, "whetherSevere");
            return (Criteria) this;
        }

        public Criteria andWhetherSevereLessThan(String value) {
            addCriterion("WHETHER_SEVERE <", value, "whetherSevere");
            return (Criteria) this;
        }

        public Criteria andWhetherSevereLessThanOrEqualTo(String value) {
            addCriterion("WHETHER_SEVERE <=", value, "whetherSevere");
            return (Criteria) this;
        }

        public Criteria andWhetherSevereLike(String value) {
            addCriterion("WHETHER_SEVERE like", value, "whetherSevere");
            return (Criteria) this;
        }

        public Criteria andWhetherSevereNotLike(String value) {
            addCriterion("WHETHER_SEVERE not like", value, "whetherSevere");
            return (Criteria) this;
        }

        public Criteria andWhetherSevereIn(List<String> values) {
            addCriterion("WHETHER_SEVERE in", values, "whetherSevere");
            return (Criteria) this;
        }

        public Criteria andWhetherSevereNotIn(List<String> values) {
            addCriterion("WHETHER_SEVERE not in", values, "whetherSevere");
            return (Criteria) this;
        }

        public Criteria andWhetherSevereBetween(String value1, String value2) {
            addCriterion("WHETHER_SEVERE between", value1, value2, "whetherSevere");
            return (Criteria) this;
        }

        public Criteria andWhetherSevereNotBetween(String value1, String value2) {
            addCriterion("WHETHER_SEVERE not between", value1, value2, "whetherSevere");
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