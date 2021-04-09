package cn.edu.dgut.epidemic.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TemperatureItineraryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TemperatureItineraryExample() {
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

        public Criteria andHealthIdIsNull() {
            addCriterion("HEALTH_ID is null");
            return (Criteria) this;
        }

        public Criteria andHealthIdIsNotNull() {
            addCriterion("HEALTH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHealthIdEqualTo(Integer value) {
            addCriterion("HEALTH_ID =", value, "healthId");
            return (Criteria) this;
        }

        public Criteria andHealthIdNotEqualTo(Integer value) {
            addCriterion("HEALTH_ID <>", value, "healthId");
            return (Criteria) this;
        }

        public Criteria andHealthIdGreaterThan(Integer value) {
            addCriterion("HEALTH_ID >", value, "healthId");
            return (Criteria) this;
        }

        public Criteria andHealthIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("HEALTH_ID >=", value, "healthId");
            return (Criteria) this;
        }

        public Criteria andHealthIdLessThan(Integer value) {
            addCriterion("HEALTH_ID <", value, "healthId");
            return (Criteria) this;
        }

        public Criteria andHealthIdLessThanOrEqualTo(Integer value) {
            addCriterion("HEALTH_ID <=", value, "healthId");
            return (Criteria) this;
        }

        public Criteria andHealthIdIn(List<Integer> values) {
            addCriterion("HEALTH_ID in", values, "healthId");
            return (Criteria) this;
        }

        public Criteria andHealthIdNotIn(List<Integer> values) {
            addCriterion("HEALTH_ID not in", values, "healthId");
            return (Criteria) this;
        }

        public Criteria andHealthIdBetween(Integer value1, Integer value2) {
            addCriterion("HEALTH_ID between", value1, value2, "healthId");
            return (Criteria) this;
        }

        public Criteria andHealthIdNotBetween(Integer value1, Integer value2) {
            addCriterion("HEALTH_ID not between", value1, value2, "healthId");
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

        public Criteria andCampusIdEqualTo(String value) {
            addCriterion("CAMPUS_ID =", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdNotEqualTo(String value) {
            addCriterion("CAMPUS_ID <>", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdGreaterThan(String value) {
            addCriterion("CAMPUS_ID >", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdGreaterThanOrEqualTo(String value) {
            addCriterion("CAMPUS_ID >=", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdLessThan(String value) {
            addCriterion("CAMPUS_ID <", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdLessThanOrEqualTo(String value) {
            addCriterion("CAMPUS_ID <=", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdLike(String value) {
            addCriterion("CAMPUS_ID like", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdNotLike(String value) {
            addCriterion("CAMPUS_ID not like", value, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdIn(List<String> values) {
            addCriterion("CAMPUS_ID in", values, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdNotIn(List<String> values) {
            addCriterion("CAMPUS_ID not in", values, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdBetween(String value1, String value2) {
            addCriterion("CAMPUS_ID between", value1, value2, "campusId");
            return (Criteria) this;
        }

        public Criteria andCampusIdNotBetween(String value1, String value2) {
            addCriterion("CAMPUS_ID not between", value1, value2, "campusId");
            return (Criteria) this;
        }

        public Criteria andPhysicalConditionIsNull() {
            addCriterion("PHYSICAL_CONDITION is null");
            return (Criteria) this;
        }

        public Criteria andPhysicalConditionIsNotNull() {
            addCriterion("PHYSICAL_CONDITION is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicalConditionEqualTo(String value) {
            addCriterion("PHYSICAL_CONDITION =", value, "physicalCondition");
            return (Criteria) this;
        }

        public Criteria andPhysicalConditionNotEqualTo(String value) {
            addCriterion("PHYSICAL_CONDITION <>", value, "physicalCondition");
            return (Criteria) this;
        }

        public Criteria andPhysicalConditionGreaterThan(String value) {
            addCriterion("PHYSICAL_CONDITION >", value, "physicalCondition");
            return (Criteria) this;
        }

        public Criteria andPhysicalConditionGreaterThanOrEqualTo(String value) {
            addCriterion("PHYSICAL_CONDITION >=", value, "physicalCondition");
            return (Criteria) this;
        }

        public Criteria andPhysicalConditionLessThan(String value) {
            addCriterion("PHYSICAL_CONDITION <", value, "physicalCondition");
            return (Criteria) this;
        }

        public Criteria andPhysicalConditionLessThanOrEqualTo(String value) {
            addCriterion("PHYSICAL_CONDITION <=", value, "physicalCondition");
            return (Criteria) this;
        }

        public Criteria andPhysicalConditionLike(String value) {
            addCriterion("PHYSICAL_CONDITION like", value, "physicalCondition");
            return (Criteria) this;
        }

        public Criteria andPhysicalConditionNotLike(String value) {
            addCriterion("PHYSICAL_CONDITION not like", value, "physicalCondition");
            return (Criteria) this;
        }

        public Criteria andPhysicalConditionIn(List<String> values) {
            addCriterion("PHYSICAL_CONDITION in", values, "physicalCondition");
            return (Criteria) this;
        }

        public Criteria andPhysicalConditionNotIn(List<String> values) {
            addCriterion("PHYSICAL_CONDITION not in", values, "physicalCondition");
            return (Criteria) this;
        }

        public Criteria andPhysicalConditionBetween(String value1, String value2) {
            addCriterion("PHYSICAL_CONDITION between", value1, value2, "physicalCondition");
            return (Criteria) this;
        }

        public Criteria andPhysicalConditionNotBetween(String value1, String value2) {
            addCriterion("PHYSICAL_CONDITION not between", value1, value2, "physicalCondition");
            return (Criteria) this;
        }

        public Criteria andItineraryRecordsIsNull() {
            addCriterion("ITINERARY_RECORDS is null");
            return (Criteria) this;
        }

        public Criteria andItineraryRecordsIsNotNull() {
            addCriterion("ITINERARY_RECORDS is not null");
            return (Criteria) this;
        }

        public Criteria andItineraryRecordsEqualTo(String value) {
            addCriterion("ITINERARY_RECORDS =", value, "itineraryRecords");
            return (Criteria) this;
        }

        public Criteria andItineraryRecordsNotEqualTo(String value) {
            addCriterion("ITINERARY_RECORDS <>", value, "itineraryRecords");
            return (Criteria) this;
        }

        public Criteria andItineraryRecordsGreaterThan(String value) {
            addCriterion("ITINERARY_RECORDS >", value, "itineraryRecords");
            return (Criteria) this;
        }

        public Criteria andItineraryRecordsGreaterThanOrEqualTo(String value) {
            addCriterion("ITINERARY_RECORDS >=", value, "itineraryRecords");
            return (Criteria) this;
        }

        public Criteria andItineraryRecordsLessThan(String value) {
            addCriterion("ITINERARY_RECORDS <", value, "itineraryRecords");
            return (Criteria) this;
        }

        public Criteria andItineraryRecordsLessThanOrEqualTo(String value) {
            addCriterion("ITINERARY_RECORDS <=", value, "itineraryRecords");
            return (Criteria) this;
        }

        public Criteria andItineraryRecordsLike(String value) {
            addCriterion("ITINERARY_RECORDS like", value, "itineraryRecords");
            return (Criteria) this;
        }

        public Criteria andItineraryRecordsNotLike(String value) {
            addCriterion("ITINERARY_RECORDS not like", value, "itineraryRecords");
            return (Criteria) this;
        }

        public Criteria andItineraryRecordsIn(List<String> values) {
            addCriterion("ITINERARY_RECORDS in", values, "itineraryRecords");
            return (Criteria) this;
        }

        public Criteria andItineraryRecordsNotIn(List<String> values) {
            addCriterion("ITINERARY_RECORDS not in", values, "itineraryRecords");
            return (Criteria) this;
        }

        public Criteria andItineraryRecordsBetween(String value1, String value2) {
            addCriterion("ITINERARY_RECORDS between", value1, value2, "itineraryRecords");
            return (Criteria) this;
        }

        public Criteria andItineraryRecordsNotBetween(String value1, String value2) {
            addCriterion("ITINERARY_RECORDS not between", value1, value2, "itineraryRecords");
            return (Criteria) this;
        }

        public Criteria andReturnedToSchoolIsNull() {
            addCriterion("RETURNED_TO_SCHOOL is null");
            return (Criteria) this;
        }

        public Criteria andReturnedToSchoolIsNotNull() {
            addCriterion("RETURNED_TO_SCHOOL is not null");
            return (Criteria) this;
        }

        public Criteria andReturnedToSchoolEqualTo(String value) {
            addCriterion("RETURNED_TO_SCHOOL =", value, "returnedToSchool");
            return (Criteria) this;
        }

        public Criteria andReturnedToSchoolNotEqualTo(String value) {
            addCriterion("RETURNED_TO_SCHOOL <>", value, "returnedToSchool");
            return (Criteria) this;
        }

        public Criteria andReturnedToSchoolGreaterThan(String value) {
            addCriterion("RETURNED_TO_SCHOOL >", value, "returnedToSchool");
            return (Criteria) this;
        }

        public Criteria andReturnedToSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("RETURNED_TO_SCHOOL >=", value, "returnedToSchool");
            return (Criteria) this;
        }

        public Criteria andReturnedToSchoolLessThan(String value) {
            addCriterion("RETURNED_TO_SCHOOL <", value, "returnedToSchool");
            return (Criteria) this;
        }

        public Criteria andReturnedToSchoolLessThanOrEqualTo(String value) {
            addCriterion("RETURNED_TO_SCHOOL <=", value, "returnedToSchool");
            return (Criteria) this;
        }

        public Criteria andReturnedToSchoolLike(String value) {
            addCriterion("RETURNED_TO_SCHOOL like", value, "returnedToSchool");
            return (Criteria) this;
        }

        public Criteria andReturnedToSchoolNotLike(String value) {
            addCriterion("RETURNED_TO_SCHOOL not like", value, "returnedToSchool");
            return (Criteria) this;
        }

        public Criteria andReturnedToSchoolIn(List<String> values) {
            addCriterion("RETURNED_TO_SCHOOL in", values, "returnedToSchool");
            return (Criteria) this;
        }

        public Criteria andReturnedToSchoolNotIn(List<String> values) {
            addCriterion("RETURNED_TO_SCHOOL not in", values, "returnedToSchool");
            return (Criteria) this;
        }

        public Criteria andReturnedToSchoolBetween(String value1, String value2) {
            addCriterion("RETURNED_TO_SCHOOL between", value1, value2, "returnedToSchool");
            return (Criteria) this;
        }

        public Criteria andReturnedToSchoolNotBetween(String value1, String value2) {
            addCriterion("RETURNED_TO_SCHOOL not between", value1, value2, "returnedToSchool");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressIsNull() {
            addCriterion("CURRENT_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressIsNotNull() {
            addCriterion("CURRENT_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressEqualTo(String value) {
            addCriterion("CURRENT_ADDRESS =", value, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressNotEqualTo(String value) {
            addCriterion("CURRENT_ADDRESS <>", value, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressGreaterThan(String value) {
            addCriterion("CURRENT_ADDRESS >", value, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENT_ADDRESS >=", value, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressLessThan(String value) {
            addCriterion("CURRENT_ADDRESS <", value, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressLessThanOrEqualTo(String value) {
            addCriterion("CURRENT_ADDRESS <=", value, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressLike(String value) {
            addCriterion("CURRENT_ADDRESS like", value, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressNotLike(String value) {
            addCriterion("CURRENT_ADDRESS not like", value, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressIn(List<String> values) {
            addCriterion("CURRENT_ADDRESS in", values, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressNotIn(List<String> values) {
            addCriterion("CURRENT_ADDRESS not in", values, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressBetween(String value1, String value2) {
            addCriterion("CURRENT_ADDRESS between", value1, value2, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andCurrentAddressNotBetween(String value1, String value2) {
            addCriterion("CURRENT_ADDRESS not between", value1, value2, "currentAddress");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNull() {
            addCriterion("TEMPERATURE is null");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNotNull() {
            addCriterion("TEMPERATURE is not null");
            return (Criteria) this;
        }

        public Criteria andTemperatureEqualTo(BigDecimal value) {
            addCriterion("TEMPERATURE =", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotEqualTo(BigDecimal value) {
            addCriterion("TEMPERATURE <>", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThan(BigDecimal value) {
            addCriterion("TEMPERATURE >", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TEMPERATURE >=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThan(BigDecimal value) {
            addCriterion("TEMPERATURE <", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TEMPERATURE <=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureIn(List<BigDecimal> values) {
            addCriterion("TEMPERATURE in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotIn(List<BigDecimal> values) {
            addCriterion("TEMPERATURE not in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TEMPERATURE between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TEMPERATURE not between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andUploadDateIsNull() {
            addCriterion("UPLOAD_DATE is null");
            return (Criteria) this;
        }

        public Criteria andUploadDateIsNotNull() {
            addCriterion("UPLOAD_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andUploadDateEqualTo(Date value) {
            addCriterion("UPLOAD_DATE =", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotEqualTo(Date value) {
            addCriterion("UPLOAD_DATE <>", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateGreaterThan(Date value) {
            addCriterion("UPLOAD_DATE >", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateGreaterThanOrEqualTo(Date value) {
            addCriterion("UPLOAD_DATE >=", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateLessThan(Date value) {
            addCriterion("UPLOAD_DATE <", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateLessThanOrEqualTo(Date value) {
            addCriterion("UPLOAD_DATE <=", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateIn(List<Date> values) {
            addCriterion("UPLOAD_DATE in", values, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotIn(List<Date> values) {
            addCriterion("UPLOAD_DATE not in", values, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateBetween(Date value1, Date value2) {
            addCriterion("UPLOAD_DATE between", value1, value2, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotBetween(Date value1, Date value2) {
            addCriterion("UPLOAD_DATE not between", value1, value2, "uploadDate");
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