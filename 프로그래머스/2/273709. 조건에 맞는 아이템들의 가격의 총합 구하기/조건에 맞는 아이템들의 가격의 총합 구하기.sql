-- 코드를 작성해주세요
select sum(PRICE) as TOTAL_PRICE from ITEM_INFO GROUP BY RARITY having RARITY = 'LEGEND'