package cn.edu.dgut.epidemic.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EpidemicContactExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EpidemicContactExample() {
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

        public Criteria andEpidemicContactIdIsNull() {
            addCriterion("EPIDEMIC_CONTACT_ID is null");
            return (Criteria) this;
        }

        public Criteria andEpidemicContactIdIsNotNull() {
            addCriterion("EPIDEMIC_CONTACT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEpidemicContactIdEqualTo(Integer value) {
            addCriterion("EPIDEMIC_CONTACT_ID =", value, "epidemicContactId");
            return (Criteria) this;
        }

        public Criteria andEpidemicContactIdNotEqualTo(Integer value) {
            addCriterion("EPIDEMIC_CONTACT_ID <>", value, "epidemicContactId");
            return (Criteria) this;
        }

        public Criteria andEpidemicContactIdGreaterThan(Integer value) {
            addCriterion("EPIDEMIC_CONTACT_ID >", value, "epidemicContactId");
            return (Criteria) this;
        }

        public Criteria andEpidemicContactIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("EPIDEMIC_CONTACT_ID >=", value, "epidemicContactId");
            return (Criteria) this;
        }

        public Criteria andEpidemicContactIdLessThan(Integer value) {
            addCriterion("EPIDEMIC_CONTACT_ID <", value, "epidemicContactId");
            return (Criteria) this;
        }

        public Criteria andEpidemicContactIdLessThanOrEqualTo(Integer value) {
            addCriterion("EPIDEMIC_CONTACT_ID <=", value, "epidemicContactId");
            return (Criteria) this;
        }

        public Criteria andEpidemicContactIdIn(List<Integer> values) {
            addCriterion("EPIDEMIC_CONTACT_ID in", values, "epidemicContactId");
            return (Criteria) this;
        }

        public Criteria andEpidemicContactIdNotIn(List<Integer> values) {
            addCriterion("EPIDEMIC_CONTACT_ID not in", values, "epidemicContactId");
            return (Criteria) this;
        }

        public Criteria andEpidemicContactIdBetween(Integer value1, Integer value2) {
            addCriterion("EPIDEMIC_CONTACT_ID between", value1, value2, "epidemicContactId");
            return (Criteria) this;
        }

        public Criteria andEpidemicContactIdNotBetween(Integer value1, Integer value2) {
            addCriterion("EPIDEMIC_CONTACT_ID not between", value1, value2, "epidemicContactId");
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

        public Criteria andContactSourceIsNull() {
            addCriterion("CONTACT_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andContactSourceIsNotNull() {
            addCriterion("CONTACT_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andContactSourceEqualTo(String value) {
            addCriterion("CONTACT_SOURCE =", value, "contactSource");
            return (Criteria) this;
        }

        public Criteria andContactSourceNotEqualTo(String value) {
            addCriterion("CONTACT_SOURCE <>", value, "contactSource");
            return (Criteria) this;
        }

        public Criteria andContactSourceGreaterThan(String value) {
            addCriterion("CONTACT_SOURCE >", value, "contactSource");
            return (Criteria) this;
        }

        public Criteria andContactSourceGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_SOURCE >=", value, "contactSource");
            return (Criteria) this;
        }

        public Criteria andContactSourceLessThan(String value) {
            addCriterion("CONTACT_SOURCE <", value, "contactSource");
            return (Criteria) this;
        }

        public Criteria andContactSourceLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_SOURCE <=", value, "contactSource");
            return (Criteria) this;
        }

        public Criteria andContactSourceLike(String value) {
            addCriterion("CONTACT_SOURCE like", value, "contactSource");
            return (Criteria) this;
        }

        public Criteria andContactSourceNotLike(String value) {
            addCriterion("CONTACT_SOURCE not like", value, "contactSource");
            return (Criteria) this;
        }

        public Criteria andContactSourceIn(List<String> values) {
            addCriterion("CONTACT_SOURCE in", values, "contactSource");
            return (Criteria) this;
        }

        public Criteria andContactSourceNotIn(List<String> values) {
            addCriterion("CONTACT_SOURCE not in", values, "contactSource");
            return (Criteria) this;
        }

        public Criteria andContactSourceBetween(String value1, String value2) {
            addCriterion("CONTACT_SOURCE between", value1, value2, "contactSource");
            return (Criteria) this;
        }

        public Criteria andContactSourceNotBetween(String value1, String value2) {
            addCriterion("CONTACT_SOURCE not between", value1, value2, "contactSource");
            return (Criteria) this;
        }

        public Criteria andIsolationAddressIsNull() {
            addCriterion("ISOLATION_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andIsolationAddressIsNotNull() {
            addCriterion("ISOLATION_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andIsolationAddressEqualTo(String value) {
            addCriterion("ISOLATION_ADDRESS =", value, "isolationAddress");
            return (Criteria) this;
        }

        public Criteria andIsolationAddressNotEqualTo(String value) {
            addCriterion("ISOLATION_ADDRESS <>", value, "isolationAddress");
            return (Criteria) this;
        }

        public Criteria andIsolationAddressGreaterThan(String value) {
            addCriterion("ISOLATION_ADDRESS >", value, "isolationAddress");
            return (Criteria) this;
        }

        public Criteria andIsolationAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ISOLATION_ADDRESS >=", value, "isolationAddress");
            return (Criteria) this;
        }

        public Criteria andIsolationAddressLessThan(String value) {
            addCriterion("ISOLATION_ADDRESS <", value, "isolationAddress");
            return (Criteria) this;
        }

        public Criteria andIsolationAddressLessThanOrEqualTo(String value) {
            addCriterion("ISOLATION_ADDRESS <=", value, "isolationAddress");
            return (Criteria) this;
        }

        public Criteria andIsolationAddressLike(String value) {
            addCriterion("ISOLATION_ADDRESS like", value, "isolationAddress");
            return (Criteria) this;
        }

        public Criteria andIsolationAddressNotLike(String value) {
            addCriterion("ISOLATION_ADDRESS not like", value, "isolationAddress");
            return (Criteria) this;
        }

        public Criteria andIsolationAddressIn(List<String> values) {
            addCriterion("ISOLATION_ADDRESS in", values, "isolationAddress");
            return (Criteria) this;
        }

        public Criteria andIsolationAddressNotIn(List<String> values) {
            addCriterion("ISOLATION_ADDRESS not in", values, "isolationAddress");
            return (Criteria) this;
        }

        public Criteria andIsolationAddressBetween(String value1, String value2) {
            addCriterion("ISOLATION_ADDRESS between", value1, value2, "isolationAddress");
            return (Criteria) this;
        }

        public Criteria andIsolationAddressNotBetween(String value1, String value2) {
            addCriterion("ISOLATION_ADDRESS not between", value1, value2, "isolationAddress");
            return (Criteria) this;
        }

        public Criteria andIsolationTimeIsNull() {
            addCriterion("ISOLATION_TIME is null");
            return (Criteria) this;
        }

        public Criteria andIsolationTimeIsNotNull() {
            addCriterion("ISOLATION_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andIsolationTimeEqualTo(Date value) {
            addCriterion("ISOLATION_TIME =", value, "isolationTime");
            return (Criteria) this;
        }

        public Criteria andIsolationTimeNotEqualTo(Date value) {
            addCriterion("ISOLATION_TIME <>", value, "isolationTime");
            return (Criteria) this;
        }

        public Criteria andIsolationTimeGreaterThan(Date value) {
            addCriterion("ISOLATION_TIME >", value, "isolationTime");
            return (Criteria) this;
        }

        public Criteria andIsolationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ISOLATION_TIME >=", value, "isolationTime");
            return (Criteria) this;
        }

        public Criteria andIsolationTimeLessThan(Date value) {
            addCriterion("ISOLATION_TIME <", value, "isolationTime");
            return (Criteria) this;
        }

        public Criteria andIsolationTimeLessThanOrEqualTo(Date value) {
            addCriterion("ISOLATION_TIME <=", value, "isolationTime");
            return (Criteria) this;
        }

        public Criteria andIsolationTimeIn(List<Date> values) {
            addCriterion("ISOLATION_TIME in", values, "isolationTime");
            return (Criteria) this;
        }

        public Criteria andIsolationTimeNotIn(List<Date> values) {
            addCriterion("ISOLATION_TIME not in", values, "isolationTime");
            return (Criteria) this;
        }

        public Criteria andIsolationTimeBetween(Date value1, Date value2) {
            addCriterion("ISOLATION_TIME between", value1, value2, "isolationTime");
            return (Criteria) this;
        }

        public Criteria andIsolationTimeNotBetween(Date value1, Date value2) {
            addCriterion("ISOLATION_TIME not between", value1, value2, "isolationTime");
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