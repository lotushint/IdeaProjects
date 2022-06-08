1. uid 和 productId 非空判断

2. 连接redis(可以用连接池)

   ```java
   JedisPool jedisPoolInstance = JedisPoolUtil.getJedisPoolInstance();
   Jedis jedis = jedisPoolInstance.getResource();
   ```

3. 拼接key(库存key,秒杀成功用户key),监视库存

4. 获取库存，如果库存null，秒杀还没有开始

5. 判断用户是否重复秒杀操作

6. 判断如果商品数量，库存数量小于 1，秒杀结束

7. 秒杀过程
   使用事务->组队操作->执行->库存-1->把秒杀成功用户添加清单里面

