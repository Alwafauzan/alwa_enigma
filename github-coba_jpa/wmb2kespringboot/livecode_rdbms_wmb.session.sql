-- t_bill = trans_date, m_customer = customer_name, m_table = table_name, m_trans_type = trans_type , t_bill_detail = sub_total
-- soal no 1
select t_bill.id bill_id,
    t_bill.trans_date,
    m_customer.customer_name,
    m_table.table_name,
    t_bill.trans_type,
    t_bill_sub_total.sub_total
from t_bill
    left join m_customer on t_bill.customer_id = m_customer.id
    left join m_table on t_bill.table_id = m_table.id
    left join (
        select t_bill_detail.bill_id,
            sum(m_menu_price.price * t_bill_detail.qty) as sub_total
        from t_bill_detail
            join m_menu_price on t_bill_detail.menu_price_id = m_menu_price.id
        group by t_bill_detail.bill_id
        order by t_bill_detail.bill_id
    ) as t_bill_sub_total on t_bill.id = t_bill_sub_total.bill_id;