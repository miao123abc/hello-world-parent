package com.hello.item.controller;

import com.hello.commons.domain.R;
import com.hello.commons.utils.PageUtils;
import com.hello.item.entity.SkuImagesEntity;
import com.hello.item.service.SkuImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * sku图片
 *
 * @author miao
 * @email 1119706268@qq.com
 * @date 2020-09-15 10:33:37
 */
@RestController
@RequestMapping("skuimages")
public class SkuImagesController {
    @Autowired
    private SkuImagesService skuImagesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("item:skuimages:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = skuImagesService.queryPage(params);

        return R.ok(page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("item:skuimages:info")
    public R info(@PathVariable("id") Long id){
		SkuImagesEntity skuImages = skuImagesService.getById(id);

        return R.ok(skuImages);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("item:skuimages:save")
    public R save(@RequestBody SkuImagesEntity skuImages){
		skuImagesService.save(skuImages);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("item:skuimages:update")
    public R update(@RequestBody SkuImagesEntity skuImages){
		skuImagesService.updateById(skuImages);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("item:skuimages:delete")
    public R delete(@RequestBody Long[] ids){
		skuImagesService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
