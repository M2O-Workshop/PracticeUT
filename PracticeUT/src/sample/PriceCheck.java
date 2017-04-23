/**
 * Copyright 2017 EIS Co., Ltd. All rights reserved.
 */

package sample;

import java.math.BigDecimal;

/**
 * @author ���� <br />
 * ���z����N���X <br />
 * ���z�A������A�N�[�|�������擾���A�ŏI�I�Ȑ������z�����肷�� <br />
 * �X�V���� 2017/04/05 �����F�V�K�쐬 <br />
 */
public class PriceCheck {
  // ���z
  private BigDecimal price;
  // ����`�F�b�N
  private boolean member;
  // �N�[�|���ԍ�
  private String coupon;
  // ����ō�
  private String tax;

  /**
   * �l�ݒ�R���X�g���N�^ <br />
   * �����Ɏg�p����I�u�W�F�N�g�ɒl��ݒ肷�� <br />
   * @param price ���z
   * @param member ���
   * @param coupon �N�[�|��
   */
  PriceCheck( BigDecimal price, boolean member, String coupon ) {
    this.price = price;
    this.member = member;
    this.coupon = coupon;
    this.tax = "1.08";
  }

  /**
   * ���z����N���X <br />
   * ���z�A������A�N�[�|�������擾���A�ŏI�I�Ȑ������z�����肷�� <br />
   * @throws Exception ��O
   * @return price ���z
   */
  public BigDecimal priceReturn() throws Exception {
    // �Ԃ�l�i�[�p
    BigDecimal finalPrice = new BigDecimal( 0 );
    
    // �N�[�|���̎�ނɂ���Ċ���
    if (this.coupon.equals( "0" )) {
      finalPrice = this.price;
      
    } else if (this.coupon.equals( "1" )) {
      finalPrice = this.price.multiply( new BigDecimal( "0.95" ) );
      
    } else if (this.coupon.equals( "2" )) {
      finalPrice = this.price.multiply( new BigDecimal( "0.90" ) );
      
    } else if (this.coupon.equals( "3" )) {
      finalPrice = this.price.multiply( new BigDecimal( "0.80" ) );
      
    } else {
      finalPrice = this.price;
    }
    
    // ����̏ꍇ�A����ŃJ�b�g
    if ( !this.member ) {
      finalPrice = finalPrice.multiply( new BigDecimal( this.tax ) );
    }
    
    // �ŏI�I�ȋ��z��Ԃ��i�����_�ȉ��͌J��グ�j
    return finalPrice.setScale( 0, BigDecimal.ROUND_UP );
  }
}
