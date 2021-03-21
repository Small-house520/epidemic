package cn.edu.dgut.epidemic.pojo;

import java.util.ArrayList;
import java.util.List;

public class PermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PermissionExample() {
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

        public Criteria andPermissionIdIsNull() {
            addCriterion("PERMISSION_ID is null");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIsNotNull() {
            addCriterion("PERMISSION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionIdEqualTo(Short value) {
            addCriterion("PERMISSION_ID =", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotEqualTo(Short value) {
            addCriterion("PERMISSION_ID <>", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThan(Short value) {
            addCriterion("PERMISSION_ID >", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThanOrEqualTo(Short value) {
            addCriterion("PERMISSION_ID >=", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThan(Short value) {
            addCriterion("PERMISSION_ID <", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThanOrEqualTo(Short value) {
            addCriterion("PERMISSION_ID <=", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIn(List<Short> values) {
            addCriterion("PERMISSION_ID in", values, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotIn(List<Short> values) {
            addCriterion("PERMISSION_ID not in", values, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdBetween(Short value1, Short value2) {
            addCriterion("PERMISSION_ID between", value1, value2, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotBetween(Short value1, Short value2) {
            addCriterion("PERMISSION_ID not between", value1, value2, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIsNull() {
            addCriterion("PERMISSION_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIsNotNull() {
            addCriterion("PERMISSION_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionNameEqualTo(String value) {
            addCriterion("PERMISSION_NAME =", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotEqualTo(String value) {
            addCriterion("PERMISSION_NAME <>", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameGreaterThan(String value) {
            addCriterion("PERMISSION_NAME >", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameGreaterThanOrEqualTo(String value) {
            addCriterion("PERMISSION_NAME >=", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLessThan(String value) {
            addCriterion("PERMISSION_NAME <", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLessThanOrEqualTo(String value) {
            addCriterion("PERMISSION_NAME <=", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLike(String value) {
            addCriterion("PERMISSION_NAME like", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotLike(String value) {
            addCriterion("PERMISSION_NAME not like", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIn(List<String> values) {
            addCriterion("PERMISSION_NAME in", values, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotIn(List<String> values) {
            addCriterion("PERMISSION_NAME not in", values, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameBetween(String value1, String value2) {
            addCriterion("PERMISSION_NAME between", value1, value2, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotBetween(String value1, String value2) {
            addCriterion("PERMISSION_NAME not between", value1, value2, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeIsNull() {
            addCriterion("PERMISSION_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeIsNotNull() {
            addCriterion("PERMISSION_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeEqualTo(String value) {
            addCriterion("PERMISSION_TYPE =", value, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNotEqualTo(String value) {
            addCriterion("PERMISSION_TYPE <>", value, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeGreaterThan(String value) {
            addCriterion("PERMISSION_TYPE >", value, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PERMISSION_TYPE >=", value, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeLessThan(String value) {
            addCriterion("PERMISSION_TYPE <", value, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeLessThanOrEqualTo(String value) {
            addCriterion("PERMISSION_TYPE <=", value, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeLike(String value) {
            addCriterion("PERMISSION_TYPE like", value, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNotLike(String value) {
            addCriterion("PERMISSION_TYPE not like", value, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeIn(List<String> values) {
            addCriterion("PERMISSION_TYPE in", values, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNotIn(List<String> values) {
            addCriterion("PERMISSION_TYPE not in", values, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeBetween(String value1, String value2) {
            addCriterion("PERMISSION_TYPE between", value1, value2, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNotBetween(String value1, String value2) {
            addCriterion("PERMISSION_TYPE not between", value1, value2, "permissionType");
            return (Criteria) this;
        }

        public Criteria andAccessUrlIsNull() {
            addCriterion("ACCESS_URL is null");
            return (Criteria) this;
        }

        public Criteria andAccessUrlIsNotNull() {
            addCriterion("ACCESS_URL is not null");
            return (Criteria) this;
        }

        public Criteria andAccessUrlEqualTo(String value) {
            addCriterion("ACCESS_URL =", value, "accessUrl");
            return (Criteria) this;
        }

        public Criteria andAccessUrlNotEqualTo(String value) {
            addCriterion("ACCESS_URL <>", value, "accessUrl");
            return (Criteria) this;
        }

        public Criteria andAccessUrlGreaterThan(String value) {
            addCriterion("ACCESS_URL >", value, "accessUrl");
            return (Criteria) this;
        }

        public Criteria andAccessUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ACCESS_URL >=", value, "accessUrl");
            return (Criteria) this;
        }

        public Criteria andAccessUrlLessThan(String value) {
            addCriterion("ACCESS_URL <", value, "accessUrl");
            return (Criteria) this;
        }

        public Criteria andAccessUrlLessThanOrEqualTo(String value) {
            addCriterion("ACCESS_URL <=", value, "accessUrl");
            return (Criteria) this;
        }

        public Criteria andAccessUrlLike(String value) {
            addCriterion("ACCESS_URL like", value, "accessUrl");
            return (Criteria) this;
        }

        public Criteria andAccessUrlNotLike(String value) {
            addCriterion("ACCESS_URL not like", value, "accessUrl");
            return (Criteria) this;
        }

        public Criteria andAccessUrlIn(List<String> values) {
            addCriterion("ACCESS_URL in", values, "accessUrl");
            return (Criteria) this;
        }

        public Criteria andAccessUrlNotIn(List<String> values) {
            addCriterion("ACCESS_URL not in", values, "accessUrl");
            return (Criteria) this;
        }

        public Criteria andAccessUrlBetween(String value1, String value2) {
            addCriterion("ACCESS_URL between", value1, value2, "accessUrl");
            return (Criteria) this;
        }

        public Criteria andAccessUrlNotBetween(String value1, String value2) {
            addCriterion("ACCESS_URL not between", value1, value2, "accessUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeIsNull() {
            addCriterion("PERMISSION_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeIsNotNull() {
            addCriterion("PERMISSION_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeEqualTo(String value) {
            addCriterion("PERMISSION_CODE =", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeNotEqualTo(String value) {
            addCriterion("PERMISSION_CODE <>", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeGreaterThan(String value) {
            addCriterion("PERMISSION_CODE >", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PERMISSION_CODE >=", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeLessThan(String value) {
            addCriterion("PERMISSION_CODE <", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeLessThanOrEqualTo(String value) {
            addCriterion("PERMISSION_CODE <=", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeLike(String value) {
            addCriterion("PERMISSION_CODE like", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeNotLike(String value) {
            addCriterion("PERMISSION_CODE not like", value, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeIn(List<String> values) {
            addCriterion("PERMISSION_CODE in", values, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeNotIn(List<String> values) {
            addCriterion("PERMISSION_CODE not in", values, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeBetween(String value1, String value2) {
            addCriterion("PERMISSION_CODE between", value1, value2, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andPermissionCodeNotBetween(String value1, String value2) {
            addCriterion("PERMISSION_CODE not between", value1, value2, "permissionCode");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("PARENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("PARENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Short value) {
            addCriterion("PARENT_ID =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Short value) {
            addCriterion("PARENT_ID <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Short value) {
            addCriterion("PARENT_ID >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Short value) {
            addCriterion("PARENT_ID >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Short value) {
            addCriterion("PARENT_ID <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Short value) {
            addCriterion("PARENT_ID <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Short> values) {
            addCriterion("PARENT_ID in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Short> values) {
            addCriterion("PARENT_ID not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Short value1, Short value2) {
            addCriterion("PARENT_ID between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Short value1, Short value2) {
            addCriterion("PARENT_ID not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdListIsNull() {
            addCriterion("PARENT_ID_LIST is null");
            return (Criteria) this;
        }

        public Criteria andParentIdListIsNotNull() {
            addCriterion("PARENT_ID_LIST is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdListEqualTo(String value) {
            addCriterion("PARENT_ID_LIST =", value, "parentIdList");
            return (Criteria) this;
        }

        public Criteria andParentIdListNotEqualTo(String value) {
            addCriterion("PARENT_ID_LIST <>", value, "parentIdList");
            return (Criteria) this;
        }

        public Criteria andParentIdListGreaterThan(String value) {
            addCriterion("PARENT_ID_LIST >", value, "parentIdList");
            return (Criteria) this;
        }

        public Criteria andParentIdListGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_ID_LIST >=", value, "parentIdList");
            return (Criteria) this;
        }

        public Criteria andParentIdListLessThan(String value) {
            addCriterion("PARENT_ID_LIST <", value, "parentIdList");
            return (Criteria) this;
        }

        public Criteria andParentIdListLessThanOrEqualTo(String value) {
            addCriterion("PARENT_ID_LIST <=", value, "parentIdList");
            return (Criteria) this;
        }

        public Criteria andParentIdListLike(String value) {
            addCriterion("PARENT_ID_LIST like", value, "parentIdList");
            return (Criteria) this;
        }

        public Criteria andParentIdListNotLike(String value) {
            addCriterion("PARENT_ID_LIST not like", value, "parentIdList");
            return (Criteria) this;
        }

        public Criteria andParentIdListIn(List<String> values) {
            addCriterion("PARENT_ID_LIST in", values, "parentIdList");
            return (Criteria) this;
        }

        public Criteria andParentIdListNotIn(List<String> values) {
            addCriterion("PARENT_ID_LIST not in", values, "parentIdList");
            return (Criteria) this;
        }

        public Criteria andParentIdListBetween(String value1, String value2) {
            addCriterion("PARENT_ID_LIST between", value1, value2, "parentIdList");
            return (Criteria) this;
        }

        public Criteria andParentIdListNotBetween(String value1, String value2) {
            addCriterion("PARENT_ID_LIST not between", value1, value2, "parentIdList");
            return (Criteria) this;
        }

        public Criteria andPermissionMenuSortingIsNull() {
            addCriterion("PERMISSION_MENU_SORTING is null");
            return (Criteria) this;
        }

        public Criteria andPermissionMenuSortingIsNotNull() {
            addCriterion("PERMISSION_MENU_SORTING is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionMenuSortingEqualTo(String value) {
            addCriterion("PERMISSION_MENU_SORTING =", value, "permissionMenuSorting");
            return (Criteria) this;
        }

        public Criteria andPermissionMenuSortingNotEqualTo(String value) {
            addCriterion("PERMISSION_MENU_SORTING <>", value, "permissionMenuSorting");
            return (Criteria) this;
        }

        public Criteria andPermissionMenuSortingGreaterThan(String value) {
            addCriterion("PERMISSION_MENU_SORTING >", value, "permissionMenuSorting");
            return (Criteria) this;
        }

        public Criteria andPermissionMenuSortingGreaterThanOrEqualTo(String value) {
            addCriterion("PERMISSION_MENU_SORTING >=", value, "permissionMenuSorting");
            return (Criteria) this;
        }

        public Criteria andPermissionMenuSortingLessThan(String value) {
            addCriterion("PERMISSION_MENU_SORTING <", value, "permissionMenuSorting");
            return (Criteria) this;
        }

        public Criteria andPermissionMenuSortingLessThanOrEqualTo(String value) {
            addCriterion("PERMISSION_MENU_SORTING <=", value, "permissionMenuSorting");
            return (Criteria) this;
        }

        public Criteria andPermissionMenuSortingLike(String value) {
            addCriterion("PERMISSION_MENU_SORTING like", value, "permissionMenuSorting");
            return (Criteria) this;
        }

        public Criteria andPermissionMenuSortingNotLike(String value) {
            addCriterion("PERMISSION_MENU_SORTING not like", value, "permissionMenuSorting");
            return (Criteria) this;
        }

        public Criteria andPermissionMenuSortingIn(List<String> values) {
            addCriterion("PERMISSION_MENU_SORTING in", values, "permissionMenuSorting");
            return (Criteria) this;
        }

        public Criteria andPermissionMenuSortingNotIn(List<String> values) {
            addCriterion("PERMISSION_MENU_SORTING not in", values, "permissionMenuSorting");
            return (Criteria) this;
        }

        public Criteria andPermissionMenuSortingBetween(String value1, String value2) {
            addCriterion("PERMISSION_MENU_SORTING between", value1, value2, "permissionMenuSorting");
            return (Criteria) this;
        }

        public Criteria andPermissionMenuSortingNotBetween(String value1, String value2) {
            addCriterion("PERMISSION_MENU_SORTING not between", value1, value2, "permissionMenuSorting");
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