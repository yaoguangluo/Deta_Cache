一个java json rest缓存服务器， 源码20kb，基于VPCS HTTP服务器, 启动仅需9毫秒。
# vpc_deta_cache
# JDK的不断更新导致hashmap的索引采用2分法思想发挥到极致，所以本deta cache的后序完善将放缓，新的任务本人将基于VPCS的Hall keeper 和运维更有效的交互进行深入研究，设计的研究项目如下
新开一个用于缓存vpc部署 并集成了德塔数据库请求UTIL，
##### 已完善功能：集成了德塔rest服务器做缓存业务。可springBoot 和 detaBoot 2选1启动。 Mr.Luo
##### 已完善功能：REST请求。 Mr.Luo
##### 已完善功能：200 反馈。 Mr.Luo
##### 已完善功能：500 反馈。 Mr.Luo
##### 已完善功能：restMap。 Mr.Luo
##### 已完善功能：restForward。 Mr.Luo
##### 已完善功能：每秒1500并发控制。 Mr.Luo
##### 已完善功能：json 读写。 Mr.Luo
##### 已完善功能：时间设计。 Mr.Luo
##### 已完善功能：增加缓存超时更新机制。 Mr.Luo
##### 已完善功能：单机 10万 QPS。已测试。 Mr.Luo
##### 已完善功能：String to bit 2采用gzip进制快速压缩。 Mr.Luo

##### 正完善功能：restPath=/getServerInfo 运维接口 定义   Mr.Chen
##### 正完善功能：restPath=/getServerInfo 运维接口 结构   Mr.Chen
##### 正完善功能：restPath=/getServerInfo 运维接口 研发   Mr.Chen


##### 未完善功能：proxy cache；
##### 未完善功能：map 分级序列化索引。
##### 未完善功能：准备全部剔除springboot。  
##### 未完善功能：引用VPCS skivvy 清理功能。
##### 未完善功能：hallkeeper admin页面 与运维交互
##### 未完善功能：配置的单例类
##### 未完善功能：编程规范引入sonar认证

##### 新任务：hallkeeper 系统日志分级管理。
##### 新任务：hallkeeper 系统日志分级反馈。
##### 新任务：离散的运维调试接口集合。
##### 新任务：可视化运维界面系统，admin 和desk app
##### 新任务：基于deta etl的 可重用的运维管理界面设计.
##### 新任务：运维流程进行可逆化离散操作。



