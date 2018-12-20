package com.lc.web.resource.entity;

import java.util.ArrayList;
import java.util.List;

public class TreespeciesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TreespeciesExample() {
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

        public Criteria andTreespeciesidIsNull() {
            addCriterion("treespeciesid is null");
            return (Criteria) this;
        }

        public Criteria andTreespeciesidIsNotNull() {
            addCriterion("treespeciesid is not null");
            return (Criteria) this;
        }

        public Criteria andTreespeciesidEqualTo(Integer value) {
            addCriterion("treespeciesid =", value, "treespeciesid");
            return (Criteria) this;
        }

        public Criteria andTreespeciesidNotEqualTo(Integer value) {
            addCriterion("treespeciesid <>", value, "treespeciesid");
            return (Criteria) this;
        }

        public Criteria andTreespeciesidGreaterThan(Integer value) {
            addCriterion("treespeciesid >", value, "treespeciesid");
            return (Criteria) this;
        }

        public Criteria andTreespeciesidGreaterThanOrEqualTo(Integer value) {
            addCriterion("treespeciesid >=", value, "treespeciesid");
            return (Criteria) this;
        }

        public Criteria andTreespeciesidLessThan(Integer value) {
            addCriterion("treespeciesid <", value, "treespeciesid");
            return (Criteria) this;
        }

        public Criteria andTreespeciesidLessThanOrEqualTo(Integer value) {
            addCriterion("treespeciesid <=", value, "treespeciesid");
            return (Criteria) this;
        }

        public Criteria andTreespeciesidIn(List<Integer> values) {
            addCriterion("treespeciesid in", values, "treespeciesid");
            return (Criteria) this;
        }

        public Criteria andTreespeciesidNotIn(List<Integer> values) {
            addCriterion("treespeciesid not in", values, "treespeciesid");
            return (Criteria) this;
        }

        public Criteria andTreespeciesidBetween(Integer value1, Integer value2) {
            addCriterion("treespeciesid between", value1, value2, "treespeciesid");
            return (Criteria) this;
        }

        public Criteria andTreespeciesidNotBetween(Integer value1, Integer value2) {
            addCriterion("treespeciesid not between", value1, value2, "treespeciesid");
            return (Criteria) this;
        }

        public Criteria andTreespeciesnameIsNull() {
            addCriterion("treespeciesname is null");
            return (Criteria) this;
        }

        public Criteria andTreespeciesnameIsNotNull() {
            addCriterion("treespeciesname is not null");
            return (Criteria) this;
        }

        public Criteria andTreespeciesnameEqualTo(String value) {
            addCriterion("treespeciesname =", value, "treespeciesname");
            return (Criteria) this;
        }

        public Criteria andTreespeciesnameNotEqualTo(String value) {
            addCriterion("treespeciesname <>", value, "treespeciesname");
            return (Criteria) this;
        }

        public Criteria andTreespeciesnameGreaterThan(String value) {
            addCriterion("treespeciesname >", value, "treespeciesname");
            return (Criteria) this;
        }

        public Criteria andTreespeciesnameGreaterThanOrEqualTo(String value) {
            addCriterion("treespeciesname >=", value, "treespeciesname");
            return (Criteria) this;
        }

        public Criteria andTreespeciesnameLessThan(String value) {
            addCriterion("treespeciesname <", value, "treespeciesname");
            return (Criteria) this;
        }

        public Criteria andTreespeciesnameLessThanOrEqualTo(String value) {
            addCriterion("treespeciesname <=", value, "treespeciesname");
            return (Criteria) this;
        }

        public Criteria andTreespeciesnameLike(String value) {
            addCriterion("treespeciesname like", value, "treespeciesname");
            return (Criteria) this;
        }

        public Criteria andTreespeciesnameNotLike(String value) {
            addCriterion("treespeciesname not like", value, "treespeciesname");
            return (Criteria) this;
        }

        public Criteria andTreespeciesnameIn(List<String> values) {
            addCriterion("treespeciesname in", values, "treespeciesname");
            return (Criteria) this;
        }

        public Criteria andTreespeciesnameNotIn(List<String> values) {
            addCriterion("treespeciesname not in", values, "treespeciesname");
            return (Criteria) this;
        }

        public Criteria andTreespeciesnameBetween(String value1, String value2) {
            addCriterion("treespeciesname between", value1, value2, "treespeciesname");
            return (Criteria) this;
        }

        public Criteria andTreespeciesnameNotBetween(String value1, String value2) {
            addCriterion("treespeciesname not between", value1, value2, "treespeciesname");
            return (Criteria) this;
        }

        public Criteria andSectionIsNull() {
            addCriterion("section is null");
            return (Criteria) this;
        }

        public Criteria andSectionIsNotNull() {
            addCriterion("section is not null");
            return (Criteria) this;
        }

        public Criteria andSectionEqualTo(String value) {
            addCriterion("section =", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotEqualTo(String value) {
            addCriterion("section <>", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionGreaterThan(String value) {
            addCriterion("section >", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionGreaterThanOrEqualTo(String value) {
            addCriterion("section >=", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionLessThan(String value) {
            addCriterion("section <", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionLessThanOrEqualTo(String value) {
            addCriterion("section <=", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionLike(String value) {
            addCriterion("section like", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotLike(String value) {
            addCriterion("section not like", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionIn(List<String> values) {
            addCriterion("section in", values, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotIn(List<String> values) {
            addCriterion("section not in", values, "section");
            return (Criteria) this;
        }

        public Criteria andSectionBetween(String value1, String value2) {
            addCriterion("section between", value1, value2, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotBetween(String value1, String value2) {
            addCriterion("section not between", value1, value2, "section");
            return (Criteria) this;
        }

        public Criteria andGenusIsNull() {
            addCriterion("genus is null");
            return (Criteria) this;
        }

        public Criteria andGenusIsNotNull() {
            addCriterion("genus is not null");
            return (Criteria) this;
        }

        public Criteria andGenusEqualTo(String value) {
            addCriterion("genus =", value, "genus");
            return (Criteria) this;
        }

        public Criteria andGenusNotEqualTo(String value) {
            addCriterion("genus <>", value, "genus");
            return (Criteria) this;
        }

        public Criteria andGenusGreaterThan(String value) {
            addCriterion("genus >", value, "genus");
            return (Criteria) this;
        }

        public Criteria andGenusGreaterThanOrEqualTo(String value) {
            addCriterion("genus >=", value, "genus");
            return (Criteria) this;
        }

        public Criteria andGenusLessThan(String value) {
            addCriterion("genus <", value, "genus");
            return (Criteria) this;
        }

        public Criteria andGenusLessThanOrEqualTo(String value) {
            addCriterion("genus <=", value, "genus");
            return (Criteria) this;
        }

        public Criteria andGenusLike(String value) {
            addCriterion("genus like", value, "genus");
            return (Criteria) this;
        }

        public Criteria andGenusNotLike(String value) {
            addCriterion("genus not like", value, "genus");
            return (Criteria) this;
        }

        public Criteria andGenusIn(List<String> values) {
            addCriterion("genus in", values, "genus");
            return (Criteria) this;
        }

        public Criteria andGenusNotIn(List<String> values) {
            addCriterion("genus not in", values, "genus");
            return (Criteria) this;
        }

        public Criteria andGenusBetween(String value1, String value2) {
            addCriterion("genus between", value1, value2, "genus");
            return (Criteria) this;
        }

        public Criteria andGenusNotBetween(String value1, String value2) {
            addCriterion("genus not between", value1, value2, "genus");
            return (Criteria) this;
        }

        public Criteria andImgpathIsNull() {
            addCriterion("imgpath is null");
            return (Criteria) this;
        }

        public Criteria andImgpathIsNotNull() {
            addCriterion("imgpath is not null");
            return (Criteria) this;
        }

        public Criteria andImgpathEqualTo(String value) {
            addCriterion("imgpath =", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotEqualTo(String value) {
            addCriterion("imgpath <>", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathGreaterThan(String value) {
            addCriterion("imgpath >", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathGreaterThanOrEqualTo(String value) {
            addCriterion("imgpath >=", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLessThan(String value) {
            addCriterion("imgpath <", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLessThanOrEqualTo(String value) {
            addCriterion("imgpath <=", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLike(String value) {
            addCriterion("imgpath like", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotLike(String value) {
            addCriterion("imgpath not like", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathIn(List<String> values) {
            addCriterion("imgpath in", values, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotIn(List<String> values) {
            addCriterion("imgpath not in", values, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathBetween(String value1, String value2) {
            addCriterion("imgpath between", value1, value2, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotBetween(String value1, String value2) {
            addCriterion("imgpath not between", value1, value2, "imgpath");
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