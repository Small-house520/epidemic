package cn.edu.dgut.epidemic.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VolunteerServiceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VolunteerServiceExample() {
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

        public Criteria andVolunteerServiceIdIsNull() {
            addCriterion("VOLUNTEER_SERVICE_ID is null");
            return (Criteria) this;
        }

        public Criteria andVolunteerServiceIdIsNotNull() {
            addCriterion("VOLUNTEER_SERVICE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andVolunteerServiceIdEqualTo(Integer value) {
            addCriterion("VOLUNTEER_SERVICE_ID =", value, "volunteerServiceId");
            return (Criteria) this;
        }

        public Criteria andVolunteerServiceIdNotEqualTo(Integer value) {
            addCriterion("VOLUNTEER_SERVICE_ID <>", value, "volunteerServiceId");
            return (Criteria) this;
        }

        public Criteria andVolunteerServiceIdGreaterThan(Integer value) {
            addCriterion("VOLUNTEER_SERVICE_ID >", value, "volunteerServiceId");
            return (Criteria) this;
        }

        public Criteria andVolunteerServiceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("VOLUNTEER_SERVICE_ID >=", value, "volunteerServiceId");
            return (Criteria) this;
        }

        public Criteria andVolunteerServiceIdLessThan(Integer value) {
            addCriterion("VOLUNTEER_SERVICE_ID <", value, "volunteerServiceId");
            return (Criteria) this;
        }

        public Criteria andVolunteerServiceIdLessThanOrEqualTo(Integer value) {
            addCriterion("VOLUNTEER_SERVICE_ID <=", value, "volunteerServiceId");
            return (Criteria) this;
        }

        public Criteria andVolunteerServiceIdIn(List<Integer> values) {
            addCriterion("VOLUNTEER_SERVICE_ID in", values, "volunteerServiceId");
            return (Criteria) this;
        }

        public Criteria andVolunteerServiceIdNotIn(List<Integer> values) {
            addCriterion("VOLUNTEER_SERVICE_ID not in", values, "volunteerServiceId");
            return (Criteria) this;
        }

        public Criteria andVolunteerServiceIdBetween(Integer value1, Integer value2) {
            addCriterion("VOLUNTEER_SERVICE_ID between", value1, value2, "volunteerServiceId");
            return (Criteria) this;
        }

        public Criteria andVolunteerServiceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("VOLUNTEER_SERVICE_ID not between", value1, value2, "volunteerServiceId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andDetailsIsNull() {
            addCriterion("DETAILS is null");
            return (Criteria) this;
        }

        public Criteria andDetailsIsNotNull() {
            addCriterion("DETAILS is not null");
            return (Criteria) this;
        }

        public Criteria andDetailsEqualTo(String value) {
            addCriterion("DETAILS =", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsNotEqualTo(String value) {
            addCriterion("DETAILS <>", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsGreaterThan(String value) {
            addCriterion("DETAILS >", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("DETAILS >=", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsLessThan(String value) {
            addCriterion("DETAILS <", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsLessThanOrEqualTo(String value) {
            addCriterion("DETAILS <=", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsLike(String value) {
            addCriterion("DETAILS like", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsNotLike(String value) {
            addCriterion("DETAILS not like", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsIn(List<String> values) {
            addCriterion("DETAILS in", values, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsNotIn(List<String> values) {
            addCriterion("DETAILS not in", values, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsBetween(String value1, String value2) {
            addCriterion("DETAILS between", value1, value2, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsNotBetween(String value1, String value2) {
            addCriterion("DETAILS not between", value1, value2, "details");
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

        public Criteria andSponsorOrgIsNull() {
            addCriterion("SPONSOR_ORG is null");
            return (Criteria) this;
        }

        public Criteria andSponsorOrgIsNotNull() {
            addCriterion("SPONSOR_ORG is not null");
            return (Criteria) this;
        }

        public Criteria andSponsorOrgEqualTo(String value) {
            addCriterion("SPONSOR_ORG =", value, "sponsorOrg");
            return (Criteria) this;
        }

        public Criteria andSponsorOrgNotEqualTo(String value) {
            addCriterion("SPONSOR_ORG <>", value, "sponsorOrg");
            return (Criteria) this;
        }

        public Criteria andSponsorOrgGreaterThan(String value) {
            addCriterion("SPONSOR_ORG >", value, "sponsorOrg");
            return (Criteria) this;
        }

        public Criteria andSponsorOrgGreaterThanOrEqualTo(String value) {
            addCriterion("SPONSOR_ORG >=", value, "sponsorOrg");
            return (Criteria) this;
        }

        public Criteria andSponsorOrgLessThan(String value) {
            addCriterion("SPONSOR_ORG <", value, "sponsorOrg");
            return (Criteria) this;
        }

        public Criteria andSponsorOrgLessThanOrEqualTo(String value) {
            addCriterion("SPONSOR_ORG <=", value, "sponsorOrg");
            return (Criteria) this;
        }

        public Criteria andSponsorOrgLike(String value) {
            addCriterion("SPONSOR_ORG like", value, "sponsorOrg");
            return (Criteria) this;
        }

        public Criteria andSponsorOrgNotLike(String value) {
            addCriterion("SPONSOR_ORG not like", value, "sponsorOrg");
            return (Criteria) this;
        }

        public Criteria andSponsorOrgIn(List<String> values) {
            addCriterion("SPONSOR_ORG in", values, "sponsorOrg");
            return (Criteria) this;
        }

        public Criteria andSponsorOrgNotIn(List<String> values) {
            addCriterion("SPONSOR_ORG not in", values, "sponsorOrg");
            return (Criteria) this;
        }

        public Criteria andSponsorOrgBetween(String value1, String value2) {
            addCriterion("SPONSOR_ORG between", value1, value2, "sponsorOrg");
            return (Criteria) this;
        }

        public Criteria andSponsorOrgNotBetween(String value1, String value2) {
            addCriterion("SPONSOR_ORG not between", value1, value2, "sponsorOrg");
            return (Criteria) this;
        }

        public Criteria andExpectedVolunteersIsNull() {
            addCriterion("EXPECTED_VOLUNTEERS is null");
            return (Criteria) this;
        }

        public Criteria andExpectedVolunteersIsNotNull() {
            addCriterion("EXPECTED_VOLUNTEERS is not null");
            return (Criteria) this;
        }

        public Criteria andExpectedVolunteersEqualTo(Short value) {
            addCriterion("EXPECTED_VOLUNTEERS =", value, "expectedVolunteers");
            return (Criteria) this;
        }

        public Criteria andExpectedVolunteersNotEqualTo(Short value) {
            addCriterion("EXPECTED_VOLUNTEERS <>", value, "expectedVolunteers");
            return (Criteria) this;
        }

        public Criteria andExpectedVolunteersGreaterThan(Short value) {
            addCriterion("EXPECTED_VOLUNTEERS >", value, "expectedVolunteers");
            return (Criteria) this;
        }

        public Criteria andExpectedVolunteersGreaterThanOrEqualTo(Short value) {
            addCriterion("EXPECTED_VOLUNTEERS >=", value, "expectedVolunteers");
            return (Criteria) this;
        }

        public Criteria andExpectedVolunteersLessThan(Short value) {
            addCriterion("EXPECTED_VOLUNTEERS <", value, "expectedVolunteers");
            return (Criteria) this;
        }

        public Criteria andExpectedVolunteersLessThanOrEqualTo(Short value) {
            addCriterion("EXPECTED_VOLUNTEERS <=", value, "expectedVolunteers");
            return (Criteria) this;
        }

        public Criteria andExpectedVolunteersIn(List<Short> values) {
            addCriterion("EXPECTED_VOLUNTEERS in", values, "expectedVolunteers");
            return (Criteria) this;
        }

        public Criteria andExpectedVolunteersNotIn(List<Short> values) {
            addCriterion("EXPECTED_VOLUNTEERS not in", values, "expectedVolunteers");
            return (Criteria) this;
        }

        public Criteria andExpectedVolunteersBetween(Short value1, Short value2) {
            addCriterion("EXPECTED_VOLUNTEERS between", value1, value2, "expectedVolunteers");
            return (Criteria) this;
        }

        public Criteria andExpectedVolunteersNotBetween(Short value1, Short value2) {
            addCriterion("EXPECTED_VOLUNTEERS not between", value1, value2, "expectedVolunteers");
            return (Criteria) this;
        }

        public Criteria andConditionsIsNull() {
            addCriterion("CONDITIONS is null");
            return (Criteria) this;
        }

        public Criteria andConditionsIsNotNull() {
            addCriterion("CONDITIONS is not null");
            return (Criteria) this;
        }

        public Criteria andConditionsEqualTo(String value) {
            addCriterion("CONDITIONS =", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsNotEqualTo(String value) {
            addCriterion("CONDITIONS <>", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsGreaterThan(String value) {
            addCriterion("CONDITIONS >", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsGreaterThanOrEqualTo(String value) {
            addCriterion("CONDITIONS >=", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsLessThan(String value) {
            addCriterion("CONDITIONS <", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsLessThanOrEqualTo(String value) {
            addCriterion("CONDITIONS <=", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsLike(String value) {
            addCriterion("CONDITIONS like", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsNotLike(String value) {
            addCriterion("CONDITIONS not like", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsIn(List<String> values) {
            addCriterion("CONDITIONS in", values, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsNotIn(List<String> values) {
            addCriterion("CONDITIONS not in", values, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsBetween(String value1, String value2) {
            addCriterion("CONDITIONS between", value1, value2, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsNotBetween(String value1, String value2) {
            addCriterion("CONDITIONS not between", value1, value2, "conditions");
            return (Criteria) this;
        }

        public Criteria andParticipatedVolunteersIsNull() {
            addCriterion("PARTICIPATED_VOLUNTEERS is null");
            return (Criteria) this;
        }

        public Criteria andParticipatedVolunteersIsNotNull() {
            addCriterion("PARTICIPATED_VOLUNTEERS is not null");
            return (Criteria) this;
        }

        public Criteria andParticipatedVolunteersEqualTo(Short value) {
            addCriterion("PARTICIPATED_VOLUNTEERS =", value, "participatedVolunteers");
            return (Criteria) this;
        }

        public Criteria andParticipatedVolunteersNotEqualTo(Short value) {
            addCriterion("PARTICIPATED_VOLUNTEERS <>", value, "participatedVolunteers");
            return (Criteria) this;
        }

        public Criteria andParticipatedVolunteersGreaterThan(Short value) {
            addCriterion("PARTICIPATED_VOLUNTEERS >", value, "participatedVolunteers");
            return (Criteria) this;
        }

        public Criteria andParticipatedVolunteersGreaterThanOrEqualTo(Short value) {
            addCriterion("PARTICIPATED_VOLUNTEERS >=", value, "participatedVolunteers");
            return (Criteria) this;
        }

        public Criteria andParticipatedVolunteersLessThan(Short value) {
            addCriterion("PARTICIPATED_VOLUNTEERS <", value, "participatedVolunteers");
            return (Criteria) this;
        }

        public Criteria andParticipatedVolunteersLessThanOrEqualTo(Short value) {
            addCriterion("PARTICIPATED_VOLUNTEERS <=", value, "participatedVolunteers");
            return (Criteria) this;
        }

        public Criteria andParticipatedVolunteersIn(List<Short> values) {
            addCriterion("PARTICIPATED_VOLUNTEERS in", values, "participatedVolunteers");
            return (Criteria) this;
        }

        public Criteria andParticipatedVolunteersNotIn(List<Short> values) {
            addCriterion("PARTICIPATED_VOLUNTEERS not in", values, "participatedVolunteers");
            return (Criteria) this;
        }

        public Criteria andParticipatedVolunteersBetween(Short value1, Short value2) {
            addCriterion("PARTICIPATED_VOLUNTEERS between", value1, value2, "participatedVolunteers");
            return (Criteria) this;
        }

        public Criteria andParticipatedVolunteersNotBetween(Short value1, Short value2) {
            addCriterion("PARTICIPATED_VOLUNTEERS not between", value1, value2, "participatedVolunteers");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("LOCATION is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("LOCATION is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("LOCATION =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("LOCATION <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("LOCATION >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATION >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("LOCATION <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("LOCATION <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("LOCATION like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("LOCATION not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("LOCATION in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("LOCATION not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("LOCATION between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("LOCATION not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andInitiateTimeIsNull() {
            addCriterion("INITIATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andInitiateTimeIsNotNull() {
            addCriterion("INITIATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andInitiateTimeEqualTo(Date value) {
            addCriterion("INITIATE_TIME =", value, "initiateTime");
            return (Criteria) this;
        }

        public Criteria andInitiateTimeNotEqualTo(Date value) {
            addCriterion("INITIATE_TIME <>", value, "initiateTime");
            return (Criteria) this;
        }

        public Criteria andInitiateTimeGreaterThan(Date value) {
            addCriterion("INITIATE_TIME >", value, "initiateTime");
            return (Criteria) this;
        }

        public Criteria andInitiateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("INITIATE_TIME >=", value, "initiateTime");
            return (Criteria) this;
        }

        public Criteria andInitiateTimeLessThan(Date value) {
            addCriterion("INITIATE_TIME <", value, "initiateTime");
            return (Criteria) this;
        }

        public Criteria andInitiateTimeLessThanOrEqualTo(Date value) {
            addCriterion("INITIATE_TIME <=", value, "initiateTime");
            return (Criteria) this;
        }

        public Criteria andInitiateTimeIn(List<Date> values) {
            addCriterion("INITIATE_TIME in", values, "initiateTime");
            return (Criteria) this;
        }

        public Criteria andInitiateTimeNotIn(List<Date> values) {
            addCriterion("INITIATE_TIME not in", values, "initiateTime");
            return (Criteria) this;
        }

        public Criteria andInitiateTimeBetween(Date value1, Date value2) {
            addCriterion("INITIATE_TIME between", value1, value2, "initiateTime");
            return (Criteria) this;
        }

        public Criteria andInitiateTimeNotBetween(Date value1, Date value2) {
            addCriterion("INITIATE_TIME not between", value1, value2, "initiateTime");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNull() {
            addCriterion("DEADLINE is null");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNotNull() {
            addCriterion("DEADLINE is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlineEqualTo(Date value) {
            addCriterion("DEADLINE =", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotEqualTo(Date value) {
            addCriterion("DEADLINE <>", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThan(Date value) {
            addCriterion("DEADLINE >", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("DEADLINE >=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThan(Date value) {
            addCriterion("DEADLINE <", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("DEADLINE <=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineIn(List<Date> values) {
            addCriterion("DEADLINE in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotIn(List<Date> values) {
            addCriterion("DEADLINE not in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineBetween(Date value1, Date value2) {
            addCriterion("DEADLINE between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("DEADLINE not between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
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