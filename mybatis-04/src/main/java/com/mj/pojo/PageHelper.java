package com.mj.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author : MaJ
 * @date : 2021/11/19
 * @description ：分页
 */
@Data
public class PageHelper<T> {
    /**
     * 排序
     */
    protected String orderClause;
    /**
     * 当前页数，默认第 1 页
     */
    protected int currentPage = 1;
    /**
     * 总页数，默认 1
     */
    protected int totalPage = 1;
    /**
     * 每页数据量，默认 10
     */
    protected int pageSize = 10;
    /**
     * 总数居量，默认 0
     */
    protected int totalSize = 0;
    /**
     * 每页分页数据的起始查询数
     */
    protected int start = -1;
    /**
     * 响应数据
     */
    protected List<T> result;


    public void setPageInfo(int totalSize, int pageSize, int currentPage) {
        this.totalSize = totalSize;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.start = (this.currentPage - 1) * pageSize;
        if (this.totalSize != 0) {
            this.totalSize = this.totalSize / this.pageSize + (this.totalSize % this.pageSize == 0 ? 0 : 1);
        }
    }

    public void setTotalSize(final int totalSize) {
        if (totalSize < 0) {
            throw new IllegalArgumentException("总记录数不能小于 0 ");
        }
        this.totalSize = totalSize;
        this.start = (this.currentPage - 1) * pageSize;
        this.totalSize = this.totalSize / this.pageSize + (this.totalSize % this.pageSize == 0 ? 0 : 1);
    }

    public void setPageSize(final int pageSize) {
        if (pageSize < 0) {
            throw new IllegalArgumentException("每页的记录数量不能小于 0 ");
        }
        this.pageSize = pageSize;
    }

    public void setCurrentPage(int currentPage) {
        if (currentPage < 0) {
            throw new IllegalArgumentException("当前页码不能小于 0 ");
        }
        this.currentPage = currentPage;
    }
}
