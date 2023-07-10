//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.web.webproject.model.response;

public class MetaList {
    private Long total;
    private Integer pageNum;
    private Integer pageSize;
    private String sortBy;
    private Boolean sortDesc;

    public static MetaListBuilder builder() {
        return new MetaListBuilder();
    }

    public Long getTotal() {
        return this.total;
    }

    public Integer getPageNum() {
        return this.pageNum;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public String getSortBy() {
        return this.sortBy;
    }

    public Boolean getSortDesc() {
        return this.sortDesc;
    }

    public void setTotal(final Long total) {
        this.total = total;
    }

    public void setPageNum(final Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setSortBy(final String sortBy) {
        this.sortBy = sortBy;
    }

    public void setSortDesc(final Boolean sortDesc) {
        this.sortDesc = sortDesc;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof MetaList)) {
            return false;
        } else {
            MetaList other = (MetaList)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71: {
                    Object this$total = this.getTotal();
                    Object other$total = other.getTotal();
                    if (this$total == null) {
                        if (other$total == null) {
                            break label71;
                        }
                    } else if (this$total.equals(other$total)) {
                        break label71;
                    }

                    return false;
                }

                Object this$pageNum = this.getPageNum();
                Object other$pageNum = other.getPageNum();
                if (this$pageNum == null) {
                    if (other$pageNum != null) {
                        return false;
                    }
                } else if (!this$pageNum.equals(other$pageNum)) {
                    return false;
                }

                label57: {
                    Object this$pageSize = this.getPageSize();
                    Object other$pageSize = other.getPageSize();
                    if (this$pageSize == null) {
                        if (other$pageSize == null) {
                            break label57;
                        }
                    } else if (this$pageSize.equals(other$pageSize)) {
                        break label57;
                    }

                    return false;
                }

                Object this$sortDesc = this.getSortDesc();
                Object other$sortDesc = other.getSortDesc();
                if (this$sortDesc == null) {
                    if (other$sortDesc != null) {
                        return false;
                    }
                } else if (!this$sortDesc.equals(other$sortDesc)) {
                    return false;
                }

                Object this$sortBy = this.getSortBy();
                Object other$sortBy = other.getSortBy();
                if (this$sortBy == null) {
                    if (other$sortBy == null) {
                        return true;
                    }
                } else if (this$sortBy.equals(other$sortBy)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MetaList;
    }

    public int hashCode() {
        int result = 1;
        Object $total = this.getTotal();
        result = result * 59 + ($total == null ? 43 : $total.hashCode());
        Object $pageNum = this.getPageNum();
        result = result * 59 + ($pageNum == null ? 43 : $pageNum.hashCode());
        Object $pageSize = this.getPageSize();
        result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
        Object $sortDesc = this.getSortDesc();
        result = result * 59 + ($sortDesc == null ? 43 : $sortDesc.hashCode());
        Object $sortBy = this.getSortBy();
        result = result * 59 + ($sortBy == null ? 43 : $sortBy.hashCode());
        return result;
    }

    public String toString() {
        Long var10000 = this.getTotal();
        return "MetaList(total=" + var10000 + ", pageNum=" + this.getPageNum() + ", pageSize=" + this.getPageSize() + ", sortBy=" + this.getSortBy() + ", sortDesc=" + this.getSortDesc() + ")";
    }

    public MetaList(final Long total, final Integer pageNum, final Integer pageSize, final String sortBy, final Boolean sortDesc) {
        this.total = total;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.sortBy = sortBy;
        this.sortDesc = sortDesc;
    }

    public MetaList() {
    }

    public static class MetaListBuilder {
        private Long total;
        private Integer pageNum;
        private Integer pageSize;
        private String sortBy;
        private Boolean sortDesc;

        MetaListBuilder() {
        }

        public MetaListBuilder total(final Long total) {
            this.total = total;
            return this;
        }

        public MetaListBuilder pageNum(final Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public MetaListBuilder pageSize(final Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public MetaListBuilder sortBy(final String sortBy) {
            this.sortBy = sortBy;
            return this;
        }

        public MetaListBuilder sortDesc(final Boolean sortDesc) {
            this.sortDesc = sortDesc;
            return this;
        }

        public MetaList build() {
            return new MetaList(this.total, this.pageNum, this.pageSize, this.sortBy, this.sortDesc);
        }

        public String toString() {
            return "MetaList.MetaListBuilder(total=" + this.total + ", pageNum=" + this.pageNum + ", pageSize=" + this.pageSize + ", sortBy=" + this.sortBy + ", sortDesc=" + this.sortDesc + ")";
        }
    }
}
