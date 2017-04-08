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
 * @author ���� <br>
 *  ���z����e�X�g�N���X <br>
 *  �����N�[�|���A������T�̗L���ŋ��z�����肷�� <br>
 *  �X�V���� 2017/04/05 �����F�V�K�쐬 <br>
 */
public class PriceCheckTest {
  /**
   * �e�X�g�P�[�X�P <br>
   * �N�[�|���F0�i�Ȃ��j
   * ������T�Ftrue�i����j <br>
   * @throws Exception ��O
   */
  @SuppressWarnings("static-access")
  @Test
  public void testCase1() throws Exception {
    // �e�X�g�ΏۃN���X�̃��b�N��
    PriceCheck pc = mock(PriceCheck.class);
    // ������T
    when(pc.memberCheck()).thenReturn( true );
    // �N�[�|���w��
    when(pc.couponCheck()).thenReturn( "0" );
    
    // �����l�Ɗ��Ғl���r
    assertEquals(PriceCheck.priceReturn(), new BigDecimal("10000"));
  }
  
  /**
   * �e�X�g�P�[�X�Q <br>
   * �N�[�|���F1�i5%OFF�j
   * ������T�Ffalse�i�Ȃ��j <br>
   * @throws Exception ��O
   */
  @SuppressWarnings("static-access")
  @Test
  public void testCase2() throws Exception {
    // �e�X�g�ΏۃN���X�̃��b�N��
    PriceCheck pc = mock(PriceCheck.class);
    // �N�[�|���w��
    when(pc.couponCheck()).thenReturn( "1" );
    // ������T
    when(pc.memberCheck()).thenReturn( false );
    
    // �����l�Ɗ��Ғl���r
    assertEquals(pc.priceReturn(), new BigDecimal("10260"));
  }
  
  /**
   * �e�X�g�P�[�X�R <br>
   * �N�[�|���F2�i10%OFF�j
   * ������T�Ftrue�i����j <br>
   * @throws Exception ��O
   */
  @SuppressWarnings("static-access")
  @Test
  public void testCase3() throws Exception {
    // �e�X�g�ΏۃN���X�̃��b�N��
    PriceCheck pc = mock(PriceCheck.class);
    // �N�[�|���w��
    when(pc.couponCheck()).thenReturn( "2" );
    // ������T
    when(pc.memberCheck()).thenReturn( true );
    
    // �����l�Ɗ��Ғl���r
    assertEquals(pc.priceReturn(), new BigDecimal("9000"));
  }
  
  /**
   * �e�X�g�P�[�X�S <br>
   * �N�[�|���F3�i20%OFF�j
   * ������T�Ffalse�i�Ȃ��j <br>
   * @throws Exception ��O
   */
  @SuppressWarnings("static-access")
  @Test
  public void testCase4() throws Exception {
    // �e�X�g�ΏۃN���X�̃��b�N��
    PriceCheck pc = mock(PriceCheck.class);
    // �N�[�|���w��
    when(pc.couponCheck()).thenReturn( "3" );
    // ������T
    when(pc.memberCheck()).thenReturn( false );
    
    // �����l�Ɗ��Ғl���r
    assertEquals(pc.priceReturn(), new BigDecimal("8640"));
  }
  
  /**
   * �e�X�g�P�[�X�T <br>
   * �N�[�|���F4�i�Ȃ��j
   * ������T�Ffalse�i�Ȃ��j <br>
   * @throws Exception ��O
   */
  @SuppressWarnings("static-access")
  @Test
  public void testCase5() throws Exception {
    // �e�X�g�ΏۃN���X�̃��b�N��
    PriceCheck pc = mock(PriceCheck.class);
    // �N�[�|���w��
    when(pc.couponCheck()).thenReturn( "4" );
    // ������T
    when(pc.memberCheck()).thenReturn( false );
    
    // �����l�Ɗ��Ғl���r
    assertEquals(pc.priceReturn(), new BigDecimal("10800"));
  }
}
