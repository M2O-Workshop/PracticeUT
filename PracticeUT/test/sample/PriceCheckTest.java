/**
 * Copyright 2017 EIS Co., Ltd. All rights reserved.
 */
package sample;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * @author 水元 <br>
 *  金額決定テストクラス <br>
 *  割引クーポン、会員特典の有無で金額を決定する <br>
 *  更新履歴 2017/04/05 水元：新規作成 <br>
 */
public class PriceCheckTest {
  /**
   * テストケース１ <br>
   * クーポン：0（なし）
   * 会員特典：true（あり） <br>
   * @throws Exception 例外
   */
  @SuppressWarnings("static-access")
  @Test
  public void testCase1() throws Exception {
    // テスト対象クラスのモック化
    PriceCheck pc = mock(PriceCheck.class);
    // 会員特典
    when(pc.memberCheck()).thenReturn( true );
    // クーポン指定
    when(pc.couponCheck()).thenReturn( "0" );
    
    // 実測値と期待値を比較
    assertEquals(PriceCheck.priceReturn(), new BigDecimal("10000"));
  }
  
  /**
   * テストケース２ <br>
   * クーポン：1（5%OFF）
   * 会員特典：false（なし） <br>
   * @throws Exception 例外
   */
  @SuppressWarnings("static-access")
  @Test
  public void testCase2() throws Exception {
    // テスト対象クラスのモック化
    PriceCheck pc = mock(PriceCheck.class);
    // クーポン指定
    when(pc.couponCheck()).thenReturn( "1" );
    // 会員特典
    when(pc.memberCheck()).thenReturn( false );
    
    // 実測値と期待値を比較
    assertEquals(pc.priceReturn(), new BigDecimal("10260"));
  }
  
  /**
   * テストケース３ <br>
   * クーポン：2（10%OFF）
   * 会員特典：true（あり） <br>
   * @throws Exception 例外
   */
  @SuppressWarnings("static-access")
  @Test
  public void testCase3() throws Exception {
    // テスト対象クラスのモック化
    PriceCheck pc = mock(PriceCheck.class);
    // クーポン指定
    when(pc.couponCheck()).thenReturn( "2" );
    // 会員特典
    when(pc.memberCheck()).thenReturn( true );
    
    // 実測値と期待値を比較
    assertEquals(pc.priceReturn(), new BigDecimal("9000"));
  }
  
  /**
   * テストケース４ <br>
   * クーポン：3（20%OFF）
   * 会員特典：false（なし） <br>
   * @throws Exception 例外
   */
  @SuppressWarnings("static-access")
  @Test
  public void testCase4() throws Exception {
    // テスト対象クラスのモック化
    PriceCheck pc = mock(PriceCheck.class);
    // クーポン指定
    when(pc.couponCheck()).thenReturn( "3" );
    // 会員特典
    when(pc.memberCheck()).thenReturn( false );
    
    // 実測値と期待値を比較
    assertEquals(pc.priceReturn(), new BigDecimal("8640"));
  }
  
  /**
   * テストケース５ <br>
   * クーポン：4（なし）
   * 会員特典：false（なし） <br>
   * @throws Exception 例外
   */
  @SuppressWarnings("static-access")
  @Test
  public void testCase5() throws Exception {
    // テスト対象クラスのモック化
    PriceCheck pc = mock(PriceCheck.class);
    // クーポン指定
    when(pc.couponCheck()).thenReturn( "4" );
    // 会員特典
    when(pc.memberCheck()).thenReturn( false );
    
    // 実測値と期待値を比較
    assertEquals(pc.priceReturn(), new BigDecimal("10800"));
  }
}
