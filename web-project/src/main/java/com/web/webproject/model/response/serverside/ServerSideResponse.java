package com.web.webproject.model.response.serverside;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

/**
 * The type Server side response.
 *
 * @param <T> the type parameter
 */
@Data
@NoArgsConstructor
public class ServerSideResponse<T extends Collection>  {

  /**
   * The Items.
   */
  private T items;

  /**
   * The Total.
   */
  private Long total;

  /**
   * Instantiates a new Server side response.
   *
   * @param items the items
   * @param total the total
   */
  @Builder(builderMethodName = "serverSideResponseBuilder")
  public ServerSideResponse(T items, Long total) {
    this.items = items;
    this.total = total;
  }
}
