ALTER TABLE MEMBERS DROP FOREIGN KEY FK_MEMBERS_Points
ALTER TABLE PRODUCTS DROP FOREIGN KEY FK_PRODUCTS_Company_ID
ALTER TABLE combo_item DROP FOREIGN KEY FK_combo_item_product_id
ALTER TABLE combo_item DROP FOREIGN KEY FK_combo_item_combo_id
ALTER TABLE marketing_tree DROP FOREIGN KEY FK_marketing_tree_customer_id
ALTER TABLE marketing_tree DROP FOREIGN KEY FK_marketing_tree_member_id
ALTER TABLE POINTS_MEMBERS DROP FOREIGN KEY FK_POINTS_MEMBERS_member_ID
ALTER TABLE POINTS_MEMBERS DROP FOREIGN KEY FK_POINTS_MEMBERS_Points_ID
DROP TABLE COMBOS
DROP TABLE COMPANY
DROP TABLE CUSTOMER
DROP TABLE MEMBERS
DROP TABLE POINTS
DROP TABLE PRODUCTS
DROP TABLE combo_item
DROP TABLE marketing_tree
DROP TABLE POINTS_MEMBERS
