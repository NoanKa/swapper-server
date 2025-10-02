package com.noanka.swapper.utility.http.response;

public class PagingResponse {
    private final int index;
    private final int size;
    private final int pageCount;

    public PagingResponse(int index, int size, int pageCount) {
        this.index = index;
        this.size = size;
        this.pageCount = pageCount;
    }

    public int getIndex() {
        return index;
    }

    public int getSize() {
        return size;
    }

    public int getPageCount() {
        return pageCount;
    }
}
