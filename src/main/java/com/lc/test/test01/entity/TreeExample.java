package com.lc.test.test01.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TreeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TreeExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andGidIsNull() {
            addCriterion("gid is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gid is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(Integer value) {
            addCriterion("gid =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(Integer value) {
            addCriterion("gid <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(Integer value) {
            addCriterion("gid >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gid >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(Integer value) {
            addCriterion("gid <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(Integer value) {
            addCriterion("gid <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<Integer> values) {
            addCriterion("gid in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<Integer> values) {
            addCriterion("gid not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(Integer value1, Integer value2) {
            addCriterion("gid between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(Integer value1, Integer value2) {
            addCriterion("gid not between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andOidIsNull() {
            addCriterion("oid_ is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oid_ is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(BigDecimal value) {
            addCriterion("oid_ =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(BigDecimal value) {
            addCriterion("oid_ <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(BigDecimal value) {
            addCriterion("oid_ >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("oid_ >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(BigDecimal value) {
            addCriterion("oid_ <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("oid_ <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<BigDecimal> values) {
            addCriterion("oid_ in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<BigDecimal> values) {
            addCriterion("oid_ not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oid_ between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oid_ not between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andContractoridIsNull() {
            addCriterion("contractorid is null");
            return (Criteria) this;
        }

        public Criteria andContractoridIsNotNull() {
            addCriterion("contractorid is not null");
            return (Criteria) this;
        }

        public Criteria andContractoridEqualTo(String value) {
            addCriterion("contractorid =", value, "contractorid");
            return (Criteria) this;
        }

        public Criteria andContractoridNotEqualTo(String value) {
            addCriterion("contractorid <>", value, "contractorid");
            return (Criteria) this;
        }

        public Criteria andContractoridGreaterThan(String value) {
            addCriterion("contractorid >", value, "contractorid");
            return (Criteria) this;
        }

        public Criteria andContractoridGreaterThanOrEqualTo(String value) {
            addCriterion("contractorid >=", value, "contractorid");
            return (Criteria) this;
        }

        public Criteria andContractoridLessThan(String value) {
            addCriterion("contractorid <", value, "contractorid");
            return (Criteria) this;
        }

        public Criteria andContractoridLessThanOrEqualTo(String value) {
            addCriterion("contractorid <=", value, "contractorid");
            return (Criteria) this;
        }

        public Criteria andContractoridLike(String value) {
            addCriterion("contractorid like", value, "contractorid");
            return (Criteria) this;
        }

        public Criteria andContractoridNotLike(String value) {
            addCriterion("contractorid not like", value, "contractorid");
            return (Criteria) this;
        }

        public Criteria andContractoridIn(List<String> values) {
            addCriterion("contractorid in", values, "contractorid");
            return (Criteria) this;
        }

        public Criteria andContractoridNotIn(List<String> values) {
            addCriterion("contractorid not in", values, "contractorid");
            return (Criteria) this;
        }

        public Criteria andContractoridBetween(String value1, String value2) {
            addCriterion("contractorid between", value1, value2, "contractorid");
            return (Criteria) this;
        }

        public Criteria andContractoridNotBetween(String value1, String value2) {
            addCriterion("contractorid not between", value1, value2, "contractorid");
            return (Criteria) this;
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andContractorIsNull() {
            addCriterion("contractor is null");
            return (Criteria) this;
        }

        public Criteria andContractorIsNotNull() {
            addCriterion("contractor is not null");
            return (Criteria) this;
        }

        public Criteria andContractorEqualTo(String value) {
            addCriterion("contractor =", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorNotEqualTo(String value) {
            addCriterion("contractor <>", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorGreaterThan(String value) {
            addCriterion("contractor >", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorGreaterThanOrEqualTo(String value) {
            addCriterion("contractor >=", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorLessThan(String value) {
            addCriterion("contractor <", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorLessThanOrEqualTo(String value) {
            addCriterion("contractor <=", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorLike(String value) {
            addCriterion("contractor like", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorNotLike(String value) {
            addCriterion("contractor not like", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorIn(List<String> values) {
            addCriterion("contractor in", values, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorNotIn(List<String> values) {
            addCriterion("contractor not in", values, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorBetween(String value1, String value2) {
            addCriterion("contractor between", value1, value2, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorNotBetween(String value1, String value2) {
            addCriterion("contractor not between", value1, value2, "contractor");
            return (Criteria) this;
        }

        public Criteria andRecorderIsNull() {
            addCriterion("recorder is null");
            return (Criteria) this;
        }

        public Criteria andRecorderIsNotNull() {
            addCriterion("recorder is not null");
            return (Criteria) this;
        }

        public Criteria andRecorderEqualTo(String value) {
            addCriterion("recorder =", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderNotEqualTo(String value) {
            addCriterion("recorder <>", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderGreaterThan(String value) {
            addCriterion("recorder >", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderGreaterThanOrEqualTo(String value) {
            addCriterion("recorder >=", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderLessThan(String value) {
            addCriterion("recorder <", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderLessThanOrEqualTo(String value) {
            addCriterion("recorder <=", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderLike(String value) {
            addCriterion("recorder like", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderNotLike(String value) {
            addCriterion("recorder not like", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderIn(List<String> values) {
            addCriterion("recorder in", values, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderNotIn(List<String> values) {
            addCriterion("recorder not in", values, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderBetween(String value1, String value2) {
            addCriterion("recorder between", value1, value2, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderNotBetween(String value1, String value2) {
            addCriterion("recorder not between", value1, value2, "recorder");
            return (Criteria) this;
        }

        public Criteria andTreespeciesIsNull() {
            addCriterion("treespecies is null");
            return (Criteria) this;
        }

        public Criteria andTreespeciesIsNotNull() {
            addCriterion("treespecies is not null");
            return (Criteria) this;
        }

        public Criteria andTreespeciesEqualTo(String value) {
            addCriterion("treespecies =", value, "treespecies");
            return (Criteria) this;
        }

        public Criteria andTreespeciesNotEqualTo(String value) {
            addCriterion("treespecies <>", value, "treespecies");
            return (Criteria) this;
        }

        public Criteria andTreespeciesGreaterThan(String value) {
            addCriterion("treespecies >", value, "treespecies");
            return (Criteria) this;
        }

        public Criteria andTreespeciesGreaterThanOrEqualTo(String value) {
            addCriterion("treespecies >=", value, "treespecies");
            return (Criteria) this;
        }

        public Criteria andTreespeciesLessThan(String value) {
            addCriterion("treespecies <", value, "treespecies");
            return (Criteria) this;
        }

        public Criteria andTreespeciesLessThanOrEqualTo(String value) {
            addCriterion("treespecies <=", value, "treespecies");
            return (Criteria) this;
        }

        public Criteria andTreespeciesLike(String value) {
            addCriterion("treespecies like", value, "treespecies");
            return (Criteria) this;
        }

        public Criteria andTreespeciesNotLike(String value) {
            addCriterion("treespecies not like", value, "treespecies");
            return (Criteria) this;
        }

        public Criteria andTreespeciesIn(List<String> values) {
            addCriterion("treespecies in", values, "treespecies");
            return (Criteria) this;
        }

        public Criteria andTreespeciesNotIn(List<String> values) {
            addCriterion("treespecies not in", values, "treespecies");
            return (Criteria) this;
        }

        public Criteria andTreespeciesBetween(String value1, String value2) {
            addCriterion("treespecies between", value1, value2, "treespecies");
            return (Criteria) this;
        }

        public Criteria andTreespeciesNotBetween(String value1, String value2) {
            addCriterion("treespecies not between", value1, value2, "treespecies");
            return (Criteria) this;
        }

        public Criteria andVisitageIsNull() {
            addCriterion("visitage is null");
            return (Criteria) this;
        }

        public Criteria andVisitageIsNotNull() {
            addCriterion("visitage is not null");
            return (Criteria) this;
        }

        public Criteria andVisitageEqualTo(String value) {
            addCriterion("visitage =", value, "visitage");
            return (Criteria) this;
        }

        public Criteria andVisitageNotEqualTo(String value) {
            addCriterion("visitage <>", value, "visitage");
            return (Criteria) this;
        }

        public Criteria andVisitageGreaterThan(String value) {
            addCriterion("visitage >", value, "visitage");
            return (Criteria) this;
        }

        public Criteria andVisitageGreaterThanOrEqualTo(String value) {
            addCriterion("visitage >=", value, "visitage");
            return (Criteria) this;
        }

        public Criteria andVisitageLessThan(String value) {
            addCriterion("visitage <", value, "visitage");
            return (Criteria) this;
        }

        public Criteria andVisitageLessThanOrEqualTo(String value) {
            addCriterion("visitage <=", value, "visitage");
            return (Criteria) this;
        }

        public Criteria andVisitageLike(String value) {
            addCriterion("visitage like", value, "visitage");
            return (Criteria) this;
        }

        public Criteria andVisitageNotLike(String value) {
            addCriterion("visitage not like", value, "visitage");
            return (Criteria) this;
        }

        public Criteria andVisitageIn(List<String> values) {
            addCriterion("visitage in", values, "visitage");
            return (Criteria) this;
        }

        public Criteria andVisitageNotIn(List<String> values) {
            addCriterion("visitage not in", values, "visitage");
            return (Criteria) this;
        }

        public Criteria andVisitageBetween(String value1, String value2) {
            addCriterion("visitage between", value1, value2, "visitage");
            return (Criteria) this;
        }

        public Criteria andVisitageNotBetween(String value1, String value2) {
            addCriterion("visitage not between", value1, value2, "visitage");
            return (Criteria) this;
        }

        public Criteria andTreeageIsNull() {
            addCriterion("treeage is null");
            return (Criteria) this;
        }

        public Criteria andTreeageIsNotNull() {
            addCriterion("treeage is not null");
            return (Criteria) this;
        }

        public Criteria andTreeageEqualTo(BigDecimal value) {
            addCriterion("treeage =", value, "treeage");
            return (Criteria) this;
        }

        public Criteria andTreeageNotEqualTo(BigDecimal value) {
            addCriterion("treeage <>", value, "treeage");
            return (Criteria) this;
        }

        public Criteria andTreeageGreaterThan(BigDecimal value) {
            addCriterion("treeage >", value, "treeage");
            return (Criteria) this;
        }

        public Criteria andTreeageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("treeage >=", value, "treeage");
            return (Criteria) this;
        }

        public Criteria andTreeageLessThan(BigDecimal value) {
            addCriterion("treeage <", value, "treeage");
            return (Criteria) this;
        }

        public Criteria andTreeageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("treeage <=", value, "treeage");
            return (Criteria) this;
        }

        public Criteria andTreeageIn(List<BigDecimal> values) {
            addCriterion("treeage in", values, "treeage");
            return (Criteria) this;
        }

        public Criteria andTreeageNotIn(List<BigDecimal> values) {
            addCriterion("treeage not in", values, "treeage");
            return (Criteria) this;
        }

        public Criteria andTreeageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("treeage between", value1, value2, "treeage");
            return (Criteria) this;
        }

        public Criteria andTreeageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("treeage not between", value1, value2, "treeage");
            return (Criteria) this;
        }

        public Criteria andTreeheightIsNull() {
            addCriterion("treeheight is null");
            return (Criteria) this;
        }

        public Criteria andTreeheightIsNotNull() {
            addCriterion("treeheight is not null");
            return (Criteria) this;
        }

        public Criteria andTreeheightEqualTo(BigDecimal value) {
            addCriterion("treeheight =", value, "treeheight");
            return (Criteria) this;
        }

        public Criteria andTreeheightNotEqualTo(BigDecimal value) {
            addCriterion("treeheight <>", value, "treeheight");
            return (Criteria) this;
        }

        public Criteria andTreeheightGreaterThan(BigDecimal value) {
            addCriterion("treeheight >", value, "treeheight");
            return (Criteria) this;
        }

        public Criteria andTreeheightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("treeheight >=", value, "treeheight");
            return (Criteria) this;
        }

        public Criteria andTreeheightLessThan(BigDecimal value) {
            addCriterion("treeheight <", value, "treeheight");
            return (Criteria) this;
        }

        public Criteria andTreeheightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("treeheight <=", value, "treeheight");
            return (Criteria) this;
        }

        public Criteria andTreeheightIn(List<BigDecimal> values) {
            addCriterion("treeheight in", values, "treeheight");
            return (Criteria) this;
        }

        public Criteria andTreeheightNotIn(List<BigDecimal> values) {
            addCriterion("treeheight not in", values, "treeheight");
            return (Criteria) this;
        }

        public Criteria andTreeheightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("treeheight between", value1, value2, "treeheight");
            return (Criteria) this;
        }

        public Criteria andTreeheightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("treeheight not between", value1, value2, "treeheight");
            return (Criteria) this;
        }

        public Criteria andGrounddiameterIsNull() {
            addCriterion("grounddiameter is null");
            return (Criteria) this;
        }

        public Criteria andGrounddiameterIsNotNull() {
            addCriterion("grounddiameter is not null");
            return (Criteria) this;
        }

        public Criteria andGrounddiameterEqualTo(BigDecimal value) {
            addCriterion("grounddiameter =", value, "grounddiameter");
            return (Criteria) this;
        }

        public Criteria andGrounddiameterNotEqualTo(BigDecimal value) {
            addCriterion("grounddiameter <>", value, "grounddiameter");
            return (Criteria) this;
        }

        public Criteria andGrounddiameterGreaterThan(BigDecimal value) {
            addCriterion("grounddiameter >", value, "grounddiameter");
            return (Criteria) this;
        }

        public Criteria andGrounddiameterGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("grounddiameter >=", value, "grounddiameter");
            return (Criteria) this;
        }

        public Criteria andGrounddiameterLessThan(BigDecimal value) {
            addCriterion("grounddiameter <", value, "grounddiameter");
            return (Criteria) this;
        }

        public Criteria andGrounddiameterLessThanOrEqualTo(BigDecimal value) {
            addCriterion("grounddiameter <=", value, "grounddiameter");
            return (Criteria) this;
        }

        public Criteria andGrounddiameterIn(List<BigDecimal> values) {
            addCriterion("grounddiameter in", values, "grounddiameter");
            return (Criteria) this;
        }

        public Criteria andGrounddiameterNotIn(List<BigDecimal> values) {
            addCriterion("grounddiameter not in", values, "grounddiameter");
            return (Criteria) this;
        }

        public Criteria andGrounddiameterBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("grounddiameter between", value1, value2, "grounddiameter");
            return (Criteria) this;
        }

        public Criteria andGrounddiameterNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("grounddiameter not between", value1, value2, "grounddiameter");
            return (Criteria) this;
        }

        public Criteria andTreeareaIsNull() {
            addCriterion("treearea is null");
            return (Criteria) this;
        }

        public Criteria andTreeareaIsNotNull() {
            addCriterion("treearea is not null");
            return (Criteria) this;
        }

        public Criteria andTreeareaEqualTo(BigDecimal value) {
            addCriterion("treearea =", value, "treearea");
            return (Criteria) this;
        }

        public Criteria andTreeareaNotEqualTo(BigDecimal value) {
            addCriterion("treearea <>", value, "treearea");
            return (Criteria) this;
        }

        public Criteria andTreeareaGreaterThan(BigDecimal value) {
            addCriterion("treearea >", value, "treearea");
            return (Criteria) this;
        }

        public Criteria andTreeareaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("treearea >=", value, "treearea");
            return (Criteria) this;
        }

        public Criteria andTreeareaLessThan(BigDecimal value) {
            addCriterion("treearea <", value, "treearea");
            return (Criteria) this;
        }

        public Criteria andTreeareaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("treearea <=", value, "treearea");
            return (Criteria) this;
        }

        public Criteria andTreeareaIn(List<BigDecimal> values) {
            addCriterion("treearea in", values, "treearea");
            return (Criteria) this;
        }

        public Criteria andTreeareaNotIn(List<BigDecimal> values) {
            addCriterion("treearea not in", values, "treearea");
            return (Criteria) this;
        }

        public Criteria andTreeareaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("treearea between", value1, value2, "treearea");
            return (Criteria) this;
        }

        public Criteria andTreeareaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("treearea not between", value1, value2, "treearea");
            return (Criteria) this;
        }

        public Criteria andXIsNull() {
            addCriterion("x is null");
            return (Criteria) this;
        }

        public Criteria andXIsNotNull() {
            addCriterion("x is not null");
            return (Criteria) this;
        }

        public Criteria andXEqualTo(BigDecimal value) {
            addCriterion("x =", value, "x");
            return (Criteria) this;
        }

        public Criteria andXNotEqualTo(BigDecimal value) {
            addCriterion("x <>", value, "x");
            return (Criteria) this;
        }

        public Criteria andXGreaterThan(BigDecimal value) {
            addCriterion("x >", value, "x");
            return (Criteria) this;
        }

        public Criteria andXGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("x >=", value, "x");
            return (Criteria) this;
        }

        public Criteria andXLessThan(BigDecimal value) {
            addCriterion("x <", value, "x");
            return (Criteria) this;
        }

        public Criteria andXLessThanOrEqualTo(BigDecimal value) {
            addCriterion("x <=", value, "x");
            return (Criteria) this;
        }

        public Criteria andXIn(List<BigDecimal> values) {
            addCriterion("x in", values, "x");
            return (Criteria) this;
        }

        public Criteria andXNotIn(List<BigDecimal> values) {
            addCriterion("x not in", values, "x");
            return (Criteria) this;
        }

        public Criteria andXBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("x between", value1, value2, "x");
            return (Criteria) this;
        }

        public Criteria andXNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("x not between", value1, value2, "x");
            return (Criteria) this;
        }

        public Criteria andYIsNull() {
            addCriterion("y is null");
            return (Criteria) this;
        }

        public Criteria andYIsNotNull() {
            addCriterion("y is not null");
            return (Criteria) this;
        }

        public Criteria andYEqualTo(BigDecimal value) {
            addCriterion("y =", value, "y");
            return (Criteria) this;
        }

        public Criteria andYNotEqualTo(BigDecimal value) {
            addCriterion("y <>", value, "y");
            return (Criteria) this;
        }

        public Criteria andYGreaterThan(BigDecimal value) {
            addCriterion("y >", value, "y");
            return (Criteria) this;
        }

        public Criteria andYGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("y >=", value, "y");
            return (Criteria) this;
        }

        public Criteria andYLessThan(BigDecimal value) {
            addCriterion("y <", value, "y");
            return (Criteria) this;
        }

        public Criteria andYLessThanOrEqualTo(BigDecimal value) {
            addCriterion("y <=", value, "y");
            return (Criteria) this;
        }

        public Criteria andYIn(List<BigDecimal> values) {
            addCriterion("y in", values, "y");
            return (Criteria) this;
        }

        public Criteria andYNotIn(List<BigDecimal> values) {
            addCriterion("y not in", values, "y");
            return (Criteria) this;
        }

        public Criteria andYBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("y between", value1, value2, "y");
            return (Criteria) this;
        }

        public Criteria andYNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("y not between", value1, value2, "y");
            return (Criteria) this;
        }

        public Criteria andVillageIsNull() {
            addCriterion("village is null");
            return (Criteria) this;
        }

        public Criteria andVillageIsNotNull() {
            addCriterion("village is not null");
            return (Criteria) this;
        }

        public Criteria andVillageEqualTo(String value) {
            addCriterion("village =", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageNotEqualTo(String value) {
            addCriterion("village <>", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageGreaterThan(String value) {
            addCriterion("village >", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageGreaterThanOrEqualTo(String value) {
            addCriterion("village >=", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageLessThan(String value) {
            addCriterion("village <", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageLessThanOrEqualTo(String value) {
            addCriterion("village <=", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageLike(String value) {
            addCriterion("village like", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageNotLike(String value) {
            addCriterion("village not like", value, "village");
            return (Criteria) this;
        }

        public Criteria andVillageIn(List<String> values) {
            addCriterion("village in", values, "village");
            return (Criteria) this;
        }

        public Criteria andVillageNotIn(List<String> values) {
            addCriterion("village not in", values, "village");
            return (Criteria) this;
        }

        public Criteria andVillageBetween(String value1, String value2) {
            addCriterion("village between", value1, value2, "village");
            return (Criteria) this;
        }

        public Criteria andVillageNotBetween(String value1, String value2) {
            addCriterion("village not between", value1, value2, "village");
            return (Criteria) this;
        }

        public Criteria andTownIsNull() {
            addCriterion("town is null");
            return (Criteria) this;
        }

        public Criteria andTownIsNotNull() {
            addCriterion("town is not null");
            return (Criteria) this;
        }

        public Criteria andTownEqualTo(String value) {
            addCriterion("town =", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotEqualTo(String value) {
            addCriterion("town <>", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownGreaterThan(String value) {
            addCriterion("town >", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownGreaterThanOrEqualTo(String value) {
            addCriterion("town >=", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLessThan(String value) {
            addCriterion("town <", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLessThanOrEqualTo(String value) {
            addCriterion("town <=", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLike(String value) {
            addCriterion("town like", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotLike(String value) {
            addCriterion("town not like", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownIn(List<String> values) {
            addCriterion("town in", values, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotIn(List<String> values) {
            addCriterion("town not in", values, "town");
            return (Criteria) this;
        }

        public Criteria andTownBetween(String value1, String value2) {
            addCriterion("town between", value1, value2, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotBetween(String value1, String value2) {
            addCriterion("town not between", value1, value2, "town");
            return (Criteria) this;
        }

        public Criteria andUrbanIsNull() {
            addCriterion("urban is null");
            return (Criteria) this;
        }

        public Criteria andUrbanIsNotNull() {
            addCriterion("urban is not null");
            return (Criteria) this;
        }

        public Criteria andUrbanEqualTo(String value) {
            addCriterion("urban =", value, "urban");
            return (Criteria) this;
        }

        public Criteria andUrbanNotEqualTo(String value) {
            addCriterion("urban <>", value, "urban");
            return (Criteria) this;
        }

        public Criteria andUrbanGreaterThan(String value) {
            addCriterion("urban >", value, "urban");
            return (Criteria) this;
        }

        public Criteria andUrbanGreaterThanOrEqualTo(String value) {
            addCriterion("urban >=", value, "urban");
            return (Criteria) this;
        }

        public Criteria andUrbanLessThan(String value) {
            addCriterion("urban <", value, "urban");
            return (Criteria) this;
        }

        public Criteria andUrbanLessThanOrEqualTo(String value) {
            addCriterion("urban <=", value, "urban");
            return (Criteria) this;
        }

        public Criteria andUrbanLike(String value) {
            addCriterion("urban like", value, "urban");
            return (Criteria) this;
        }

        public Criteria andUrbanNotLike(String value) {
            addCriterion("urban not like", value, "urban");
            return (Criteria) this;
        }

        public Criteria andUrbanIn(List<String> values) {
            addCriterion("urban in", values, "urban");
            return (Criteria) this;
        }

        public Criteria andUrbanNotIn(List<String> values) {
            addCriterion("urban not in", values, "urban");
            return (Criteria) this;
        }

        public Criteria andUrbanBetween(String value1, String value2) {
            addCriterion("urban between", value1, value2, "urban");
            return (Criteria) this;
        }

        public Criteria andUrbanNotBetween(String value1, String value2) {
            addCriterion("urban not between", value1, value2, "urban");
            return (Criteria) this;
        }

        public Criteria andMaintenanceIsNull() {
            addCriterion("maintenance is null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceIsNotNull() {
            addCriterion("maintenance is not null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceEqualTo(String value) {
            addCriterion("maintenance =", value, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceNotEqualTo(String value) {
            addCriterion("maintenance <>", value, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceGreaterThan(String value) {
            addCriterion("maintenance >", value, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceGreaterThanOrEqualTo(String value) {
            addCriterion("maintenance >=", value, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceLessThan(String value) {
            addCriterion("maintenance <", value, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceLessThanOrEqualTo(String value) {
            addCriterion("maintenance <=", value, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceLike(String value) {
            addCriterion("maintenance like", value, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceNotLike(String value) {
            addCriterion("maintenance not like", value, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceIn(List<String> values) {
            addCriterion("maintenance in", values, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceNotIn(List<String> values) {
            addCriterion("maintenance not in", values, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceBetween(String value1, String value2) {
            addCriterion("maintenance between", value1, value2, "maintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceNotBetween(String value1, String value2) {
            addCriterion("maintenance not between", value1, value2, "maintenance");
            return (Criteria) this;
        }

        public Criteria andGeomIsNull() {
            addCriterion("geom is null");
            return (Criteria) this;
        }

        public Criteria andGeomIsNotNull() {
            addCriterion("geom is not null");
            return (Criteria) this;
        }

        public Criteria andGeomEqualTo(Object value) {
            addCriterion("geom =", value, "geom");
            return (Criteria) this;
        }

        public Criteria andGeomNotEqualTo(Object value) {
            addCriterion("geom <>", value, "geom");
            return (Criteria) this;
        }

        public Criteria andGeomGreaterThan(Object value) {
            addCriterion("geom >", value, "geom");
            return (Criteria) this;
        }

        public Criteria andGeomGreaterThanOrEqualTo(Object value) {
            addCriterion("geom >=", value, "geom");
            return (Criteria) this;
        }

        public Criteria andGeomLessThan(Object value) {
            addCriterion("geom <", value, "geom");
            return (Criteria) this;
        }

        public Criteria andGeomLessThanOrEqualTo(Object value) {
            addCriterion("geom <=", value, "geom");
            return (Criteria) this;
        }

        public Criteria andGeomIn(List<Object> values) {
            addCriterion("geom in", values, "geom");
            return (Criteria) this;
        }

        public Criteria andGeomNotIn(List<Object> values) {
            addCriterion("geom not in", values, "geom");
            return (Criteria) this;
        }

        public Criteria andGeomBetween(Object value1, Object value2) {
            addCriterion("geom between", value1, value2, "geom");
            return (Criteria) this;
        }

        public Criteria andGeomNotBetween(Object value1, Object value2) {
            addCriterion("geom not between", value1, value2, "geom");
            return (Criteria) this;
        }

        public Criteria andGpIdIsNull() {
            addCriterion("gp_id is null");
            return (Criteria) this;
        }

        public Criteria andGpIdIsNotNull() {
            addCriterion("gp_id is not null");
            return (Criteria) this;
        }

        public Criteria andGpIdEqualTo(Integer value) {
            addCriterion("gp_id =", value, "gpId");
            return (Criteria) this;
        }

        public Criteria andGpIdNotEqualTo(Integer value) {
            addCriterion("gp_id <>", value, "gpId");
            return (Criteria) this;
        }

        public Criteria andGpIdGreaterThan(Integer value) {
            addCriterion("gp_id >", value, "gpId");
            return (Criteria) this;
        }

        public Criteria andGpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("gp_id >=", value, "gpId");
            return (Criteria) this;
        }

        public Criteria andGpIdLessThan(Integer value) {
            addCriterion("gp_id <", value, "gpId");
            return (Criteria) this;
        }

        public Criteria andGpIdLessThanOrEqualTo(Integer value) {
            addCriterion("gp_id <=", value, "gpId");
            return (Criteria) this;
        }

        public Criteria andGpIdIn(List<Integer> values) {
            addCriterion("gp_id in", values, "gpId");
            return (Criteria) this;
        }

        public Criteria andGpIdNotIn(List<Integer> values) {
            addCriterion("gp_id not in", values, "gpId");
            return (Criteria) this;
        }

        public Criteria andGpIdBetween(Integer value1, Integer value2) {
            addCriterion("gp_id between", value1, value2, "gpId");
            return (Criteria) this;
        }

        public Criteria andGpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("gp_id not between", value1, value2, "gpId");
            return (Criteria) this;
        }

        public Criteria andTreespeciesIdIsNull() {
            addCriterion("treespecies_id is null");
            return (Criteria) this;
        }

        public Criteria andTreespeciesIdIsNotNull() {
            addCriterion("treespecies_id is not null");
            return (Criteria) this;
        }

        public Criteria andTreespeciesIdEqualTo(Integer value) {
            addCriterion("treespecies_id =", value, "treespeciesId");
            return (Criteria) this;
        }

        public Criteria andTreespeciesIdNotEqualTo(Integer value) {
            addCriterion("treespecies_id <>", value, "treespeciesId");
            return (Criteria) this;
        }

        public Criteria andTreespeciesIdGreaterThan(Integer value) {
            addCriterion("treespecies_id >", value, "treespeciesId");
            return (Criteria) this;
        }

        public Criteria andTreespeciesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("treespecies_id >=", value, "treespeciesId");
            return (Criteria) this;
        }

        public Criteria andTreespeciesIdLessThan(Integer value) {
            addCriterion("treespecies_id <", value, "treespeciesId");
            return (Criteria) this;
        }

        public Criteria andTreespeciesIdLessThanOrEqualTo(Integer value) {
            addCriterion("treespecies_id <=", value, "treespeciesId");
            return (Criteria) this;
        }

        public Criteria andTreespeciesIdIn(List<Integer> values) {
            addCriterion("treespecies_id in", values, "treespeciesId");
            return (Criteria) this;
        }

        public Criteria andTreespeciesIdNotIn(List<Integer> values) {
            addCriterion("treespecies_id not in", values, "treespeciesId");
            return (Criteria) this;
        }

        public Criteria andTreespeciesIdBetween(Integer value1, Integer value2) {
            addCriterion("treespecies_id between", value1, value2, "treespeciesId");
            return (Criteria) this;
        }

        public Criteria andTreespeciesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("treespecies_id not between", value1, value2, "treespeciesId");
            return (Criteria) this;
        }

        public Criteria andTreeageVarIsNull() {
            addCriterion("treeage_var is null");
            return (Criteria) this;
        }

        public Criteria andTreeageVarIsNotNull() {
            addCriterion("treeage_var is not null");
            return (Criteria) this;
        }

        public Criteria andTreeageVarEqualTo(String value) {
            addCriterion("treeage_var =", value, "treeageVar");
            return (Criteria) this;
        }

        public Criteria andTreeageVarNotEqualTo(String value) {
            addCriterion("treeage_var <>", value, "treeageVar");
            return (Criteria) this;
        }

        public Criteria andTreeageVarGreaterThan(String value) {
            addCriterion("treeage_var >", value, "treeageVar");
            return (Criteria) this;
        }

        public Criteria andTreeageVarGreaterThanOrEqualTo(String value) {
            addCriterion("treeage_var >=", value, "treeageVar");
            return (Criteria) this;
        }

        public Criteria andTreeageVarLessThan(String value) {
            addCriterion("treeage_var <", value, "treeageVar");
            return (Criteria) this;
        }

        public Criteria andTreeageVarLessThanOrEqualTo(String value) {
            addCriterion("treeage_var <=", value, "treeageVar");
            return (Criteria) this;
        }

        public Criteria andTreeageVarLike(String value) {
            addCriterion("treeage_var like", value, "treeageVar");
            return (Criteria) this;
        }

        public Criteria andTreeageVarNotLike(String value) {
            addCriterion("treeage_var not like", value, "treeageVar");
            return (Criteria) this;
        }

        public Criteria andTreeageVarIn(List<String> values) {
            addCriterion("treeage_var in", values, "treeageVar");
            return (Criteria) this;
        }

        public Criteria andTreeageVarNotIn(List<String> values) {
            addCriterion("treeage_var not in", values, "treeageVar");
            return (Criteria) this;
        }

        public Criteria andTreeageVarBetween(String value1, String value2) {
            addCriterion("treeage_var between", value1, value2, "treeageVar");
            return (Criteria) this;
        }

        public Criteria andTreeageVarNotBetween(String value1, String value2) {
            addCriterion("treeage_var not between", value1, value2, "treeageVar");
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