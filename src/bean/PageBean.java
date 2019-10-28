package bean;

import java.util.List;

/**
 * @author ZhangHao
 * @date 2019/10/28 15:13
 * @Description： 用于封装了分页的数据,
 * 包含该页的学生数据 list
 * 总的记录数 totalSize
 * 总的页数 totalPage
 * 当前页 currentPage
 * 每页显示记录数  pageSize
 */
public class PageBean<T> {

    private int currentPage;

    private int totalPage;

    private int totalSize;

    private int pageSize;

    private List<T> list;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
