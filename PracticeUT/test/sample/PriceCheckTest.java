/**
 * Copyright 2017 EIS Co., Ltd. All rights reserved.
 */
package sample;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * @author ���� <br>
 *  ���z����e�X�g�N���X <br>
 *  �����N�[�|���A������T�̗L���ŋ��z�����肷�� <br>
 *  �X�V���� 2017/04/05 �����F�V�K�쐬 <br>
 */
public class PriceCheckTest {
  /**
   * �e�X�g�P�[�X0 <br>
   * �N�[�|���F2�i10%OFF�j
   * ������T�Ftrue�i����j <br>
   * @throws Exception ��O
   */
  @Test
  public void testCase0() throws Exception {
    // �����l�Ɗ��Ғl���r
    assertThat(PriceCheck.priceReturn(), is(new BigDecimal("90000")));
  }
}
