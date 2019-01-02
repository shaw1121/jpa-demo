## DataBase

1. 索引、联合(组合)索引
1.1 索引是加快查询速度的有效手段。系统在存取数据时会自动选择合适的索引作为存取路径。

创建索引：create [unique] [cluster] index <索引名>

删除索引：drop index <索引名>

索引是各种关系数据库系统最常见的一种逻辑单元,是关系数据库系统举足轻重的重要组成部分,对于提高检索数据速度有着至关重要的作用,索引的原理是根据索引值得到行指针,然后快速定位到数据库记录。

索引的使用

1）. 主键（默认是自带索引的）和外键（以及一些可以跟其他表关联的字段） 

2）. where子句中经常出现的字段 

3）. 索引应该建在小字段上，大数据字段（bit，image，text，blob等）不适用

1.2 联合(复合)索引------ 最左匹配原则

创建联合索引：create index <索引名称> on 表名 (字段1，字段2...);

例如：有联合索引（a,b,c,d）

select * from test where a=1 and b=2;----a和b索引都起作用

* 唯一索引

创建唯一索引的目的不是为了提高访问速度，而只是为了避免数据出现重复。唯一索引可以有多个但索引列的值必须唯一，索引列的值允许有空值。如果能确定某个数据列将只包含彼此各不相同的值，在为这个数据列创建索引的时候就应该使用关键字UNIQUE，把它定义为一个唯一索引。

2. 复合主键、联合主键
* 复合主键 

就是指你表的主键含有一个以上的字段组成
比如
    create table test
    (
    name varchar(19),
    id number,
    value varchar(10),
    primary key (name,id)
    )
上面的name和id字段组合起来就是你test表的复合主键
它的出现是因为你的name字段可能会出现重名，所以要加上ID字段这样就可以保证你记录的唯一性
一般情况下，主键的字段长度和字段数目要越少越好

* 联合主键

当一个字段无法确定唯一性的时候，需要其他字段来一起形成唯一性。就是说用来组成唯一性的字段如果有多个就是联合主键
如
学生成绩(学号,课程号,成绩)
那学号和课程号就可以做为联合主键.
因为学号和课程号决定了成绩.也就是说.你要知道成绩..你就要知道学号,知道学号,但还不能知道某一科的成绩.还要知道课程号.
所以函数依赖关系是{学号,课程号}->{成绩}
alter table tb
add constraint PK_ID primary key(学号,课程号)

* ROW_FORMAT=DYNAMIC

在mysql中， 若一张表里面不存在varchar、text以及其变形、blob以及其变形的字段的话，那么张这个表其实也叫静态表，即该表的row_format是fixed，就是说每条记录所占用的字节一样。其优点读取快，缺点浪费额外一部分空间。

若一张表里面存在varchar、text以及其变形、blob以及其变形的字段的话，那么张这个表其实也叫动态表，即该表的row_format是dynamic，就是说每条记录所占用的字节是动态的。其优点节省空间，缺点增加读取的时间开销。

* 主键和外键

https://www.cnblogs.com/buptlyn/p/4555206.html

## JPA

1、自动主键 
默认情况下，主键是一个连续的64位数字(long)，它由ObjectDB自动为存储在数据库中的每个新实体对象自动设置。数据库中的第一个实体对象的主键是1，第二个实体对象的主键是2等等。当从数据库中删除实体对象时，主键值不会被回收。 
一个实体的主键值可以通过声明一个主键字段来访问:

```java
@Entity
public class Project {
    @Id @GeneratedValue long id; // still set automatically
}
```
* @id

标注将字段标记为一个主键字段。当定义主键字段时，主键值将被ObjectDB自动注入到该字段中。 

* @generatedvalue

注释指定主键是由ObjectDB自动分配的 

* @IdClass(ProjectId.class)

复合主键由多个主键字段组成
例如，以下项目实体类的主键由两个字段组成:

```java
@Entity @IdClass(ProjectId.class)
public class Project {
    @Id int departmentId;
    @Id long projectId;
}
```
当一个实体有多个主键字段时，JPA需要定义一个特殊的ID类，该类是使用@idclass注释附加到实体类的。ID类反映了主键字段，它的对象可以表示主键值:

```java
Class ProjectId {
    int departmentId;
    long projectId;
}
```

* @Transactional
https://blog.csdn.net/hanghangde/article/details/53241150

* @ManyToOne

举个例子：
    有两张表，员工表(employee)和部门表(department)。这个时候，员工表对于部门表来说，属于ManyToOne的一个关系，对应关系为多个员工对应一个部门。当我们创建表结构时，应在多的一方去维护表关系，也就是说，应将@ManyToOne注解加在员工表中，并且设置为懒加载。

多 property 对应 一个 propertyset
多 员工                 部门
   @ManyToOne           @OneToMany
https://blog.csdn.net/CQHaveADream/article/details/80744583
https://blog.csdn.net/u010588262/article/details/76667283

* @OneToMany

https://www.jianshu.com/p/e8caafce5445

* compile group: 'org.projectlombok', name: 'lombok', version: '1.16.20'

加上这个依赖，会报编译错误，，排查很久，暂未解决
