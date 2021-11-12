/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated

import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ProductDynamicSqlSupport.Product
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ProductDynamicSqlSupport.Product.categoryId
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ProductDynamicSqlSupport.Product.name
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ProductDynamicSqlSupport.Product.price
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ProductDynamicSqlSupport.Product.productId
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ProductDynamicSqlSupport.Product.providerId
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ProductDynamicSqlSupport.Product.quantity
import jp.co.azureplus.purchase_app.infrastructure.database.mapper.generated.ProductDynamicSqlSupport.Product.url
import jp.co.azureplus.purchase_app.infrastructure.database.record.generated.ProductRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun ProductMapper.count(completer: CountCompleter) =
    countFrom(this::count, Product, completer)

fun ProductMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Product, completer)

fun ProductMapper.deleteByPrimaryKey(productId_: Long) =
    delete {
        where(productId, isEqualTo(productId_))
    }

fun ProductMapper.insert(record: ProductRecord) =
    insert(this::insert, record, Product) {
        map(productId).toProperty("productId")
        map(name).toProperty("name")
        map(price).toProperty("price")
        map(quantity).toProperty("quantity")
        map(url).toProperty("url")
        map(categoryId).toProperty("categoryId")
        map(providerId).toProperty("providerId")
    }

fun ProductMapper.insertMultiple(records: Collection<ProductRecord>) =
    insertMultiple(this::insertMultiple, records, Product) {
        map(productId).toProperty("productId")
        map(name).toProperty("name")
        map(price).toProperty("price")
        map(quantity).toProperty("quantity")
        map(url).toProperty("url")
        map(categoryId).toProperty("categoryId")
        map(providerId).toProperty("providerId")
    }

fun ProductMapper.insertMultiple(vararg records: ProductRecord) =
    insertMultiple(records.toList())

fun ProductMapper.insertSelective(record: ProductRecord) =
    insert(this::insert, record, Product) {
        map(productId).toPropertyWhenPresent("productId", record::productId)
        map(name).toPropertyWhenPresent("name", record::name)
        map(price).toPropertyWhenPresent("price", record::price)
        map(quantity).toPropertyWhenPresent("quantity", record::quantity)
        map(url).toPropertyWhenPresent("url", record::url)
        map(categoryId).toPropertyWhenPresent("categoryId", record::categoryId)
        map(providerId).toPropertyWhenPresent("providerId", record::providerId)
    }

private val columnList = listOf(productId, name, price, quantity, url, categoryId, providerId)

fun ProductMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Product, completer)

fun ProductMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Product, completer)

fun ProductMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Product, completer)

fun ProductMapper.selectByPrimaryKey(productId_: Long) =
    selectOne {
        where(productId, isEqualTo(productId_))
    }

fun ProductMapper.update(completer: UpdateCompleter) =
    update(this::update, Product, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: ProductRecord) =
    apply {
        set(productId).equalTo(record::productId)
        set(name).equalTo(record::name)
        set(price).equalTo(record::price)
        set(quantity).equalTo(record::quantity)
        set(url).equalTo(record::url)
        set(categoryId).equalTo(record::categoryId)
        set(providerId).equalTo(record::providerId)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: ProductRecord) =
    apply {
        set(productId).equalToWhenPresent(record::productId)
        set(name).equalToWhenPresent(record::name)
        set(price).equalToWhenPresent(record::price)
        set(quantity).equalToWhenPresent(record::quantity)
        set(url).equalToWhenPresent(record::url)
        set(categoryId).equalToWhenPresent(record::categoryId)
        set(providerId).equalToWhenPresent(record::providerId)
    }

fun ProductMapper.updateByPrimaryKey(record: ProductRecord) =
    update {
        set(name).equalTo(record::name)
        set(price).equalTo(record::price)
        set(quantity).equalTo(record::quantity)
        set(url).equalTo(record::url)
        set(categoryId).equalTo(record::categoryId)
        set(providerId).equalTo(record::providerId)
        where(productId, isEqualTo(record::productId))
    }

fun ProductMapper.updateByPrimaryKeySelective(record: ProductRecord) =
    update {
        set(name).equalToWhenPresent(record::name)
        set(price).equalToWhenPresent(record::price)
        set(quantity).equalToWhenPresent(record::quantity)
        set(url).equalToWhenPresent(record::url)
        set(categoryId).equalToWhenPresent(record::categoryId)
        set(providerId).equalToWhenPresent(record::providerId)
        where(productId, isEqualTo(record::productId))
    }