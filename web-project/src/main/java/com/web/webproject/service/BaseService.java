package com.web.webproject.service;

import com.web.webproject.constant.Constants;
import com.web.webproject.constant.SystemMessageCode;
import com.web.webproject.model.response.BaseResponse;
import com.web.webproject.model.response.MetaList;
import com.web.webproject.util.Helper;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.ObjectUtils;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class BaseService {
    public static final Logger LOGGER = LoggerFactory.getLogger(BaseService.class);
    @Resource
    private MessageSource messageSource;
    @Resource
    private ModelMapper modelMapper;

    public BaseService() {
    }

    protected String getMessage(String key, Object... object) {
        return this.messageSource.getMessage(key, object, LocaleContextHolder.getLocale());
    }

    protected BaseResponse<?> buildExceptionResponse(SystemMessageCode exceptionMsg, Object[] params) {
        BaseResponse<Object> response = BaseResponse.builder().code(exceptionMsg.getCode()).message(this.getMessage(exceptionMsg.getMessage(), params)).data((Object)null).build();
        LOGGER.info("API ERROR: {}", response);
        return response;
    }

    protected BaseResponse<?> buildSimpleBaseResponse(SystemMessageCode smc, Object data) {
        return BaseResponse.builder().code(smc.getCode()).message(this.getMessage(smc.getMessage())).data(data).build();
    }

    protected BaseResponse<?> buildMessageWithParamBaseResponse(SystemMessageCode smc, String param, Object data) {
        return BaseResponse.builder().code(smc.getCode()).message(this.getMessage(smc.getMessage(), param)).data(data).build();
    }

    protected Pageable buildPageable(MetaList metaList, String classNameRequest) {
        if (ObjectUtils.isEmpty(metaList)) {
            return Pageable.unpaged();
        } else {
            Pageable pageable = PageRequest.of(Constants.PAGE_NUM_DEFAULT, Constants.PAGE_SIZE_DEFAULT);
            Sort sort = Sort.unsorted();
            List<Sort.Order> orders = new ArrayList();
            Integer pageNum = metaList.getPageNum();
            Integer pageSize = metaList.getPageSize();
            if (pageNum != null && !Double.isNaN((double)pageNum) && pageSize != null && !Double.isNaN((double)pageSize)) {
                String by = null;
                if (metaList.getSortBy() != null) {
                    by = Helper.upperCamelToLowerUnderScore(metaList.getSortBy());
                }

                if (by != null) {
                    Sort.Direction direction = Boolean.TRUE.equals(metaList.getSortDesc()) ? Sort.Direction.DESC : Sort.Direction.ASC;
                    Sort.Order order = new Sort.Order(direction, by);
                    orders.add(order);
                } else {
                    Sort.Order order;
                    if (this.isDefaultSortUpdatedDate(classNameRequest)) {
                        order = new Sort.Order(Sort.Direction.DESC, "updated_date");
                    } else {
                        order = new Sort.Order(Sort.Direction.DESC, "created_date");
                    }

                    orders.add(order);
                }

                sort = Sort.by(orders);
                return PageRequest.of(pageNum, pageSize, sort);
            } else {
                return pageable;
            }
        }
    }

    protected MetaList buildMetaList(Pageable pageable, Long total) {
        Integer pageNum = pageable.isUnpaged() ? Constants.PAGE_NUM_DEFAULT : pageable.getPageNumber();
        Integer pageSize = pageable.isUnpaged() ? Constants.PAGE_SIZE_DEFAULT : pageable.getPageSize();
        return MetaList.builder().pageNum(pageNum).pageSize(pageSize).total(total).build();
    }

    private boolean isDefaultSortUpdatedDate(String classNameRequest) {
        return classNameRequest.equals("SearchDrivingLicenseTypeRequest") || classNameRequest.equals("SearchDriverRequest") || classNameRequest.equals("SearchKitSetRequest") || classNameRequest.equals("SearchScanFaceTrainingHistory");
    }

    protected String buildTextSearch(String text) {
        if (text != null && !text.isBlank()) {
            text = text.replace("%", "\\%").replace("_", "\\_");
            return text.toLowerCase().trim();
        } else {
            return text;
        }
    }
}
