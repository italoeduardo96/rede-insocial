package br.com.badbunny.redeinsocial.core.dto.response;

import br.com.badbunny.redeinsocial.core.dto.request.PageFilter;
import org.springframework.util.Assert;

import java.util.List;

public class Paginator<T> {
	
	private final PageFilter pageFilter;
	private final List<T> content;
	private final long totalElements;
	
	public Paginator(final PageFilter pageFilter, final List<T> content, final long totalElements) {
		this.pageFilter = pageFilter;
		this.content = content;
		this.totalElements = totalElements;
	}
	
	public Pagination getPagination() {
		
		final int totalPage = calculateTotalPageNumber(pageFilter.getPageSize(), totalElements);
		final boolean first = pageFilter.getPage() == 1;
		final boolean last = totalPage == pageFilter.getPage();
		
		return new Pagination(pageFilter.getPageSize(), pageFilter.getPage(), totalElements, totalPage, content.size(),
		                                                                                   first, last);
	}
	
	public static <T> Paginator<T> fromPaginatedData(PageFilter pageFilter, List<T> content, long totalElements) {
		
		Assert.isTrue(pageFilter.getPageSize() >= content.size(),
		              "Content cannot contain more element than the page size");
		
		Assert.isTrue(content.size() <= totalElements,
		              "Content size cannot contain more element than total number elements informed");
		
		Assert.isTrue((long) (pageFilter.getPage() - 1) * pageFilter.getPageSize() + content.size() <= totalElements,
		              "Total number of elements (" + totalElements + ") invalid for page (" + pageFilter.getPage() +
		              "), pageSize (" + pageFilter.getPageSize() + ") and content size provided (" + content.size()
		              + ")");
		
		return new Paginator<>(pageFilter, content, totalElements);
	}
	
	private int calculateTotalPageNumber(final int pageSize, final long totalElements) {
		return Math.toIntExact(totalElements % pageSize == 0 ? totalElements / pageSize : totalElements / pageSize + 1);
	}
	
	public PageFilter getPageFilter() {
		return pageFilter;
	}
	
	public List<T> getContent() {
		return content;
	}
	
	public long getTotalElements() {
		return totalElements;
	}
}
