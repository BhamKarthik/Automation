package utils;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class parseDynamicJson {

	public static void parseObject(JSONObject json, String key) {
		System.out.println(json.get(key));
	}

	public static void getkey(JSONObject json, String key) {
		boolean exists = json.has(key);

		Iterator<?> keys;
		String nextkeys;
		if (!exists) {
			keys = json.keys();
			while (keys.hasNext()) {
				nextkeys = (String) keys.next();
				try {
					if (json.get(nextkeys) instanceof JSONObject) {
						if (exists == false)
							getkey(json.getJSONObject(nextkeys), key);
					} else if (json.get(nextkeys) instanceof JSONObject) {
						JSONArray jasonarray = json.getJSONArray(nextkeys);
						for (int i = 0; i < jasonarray.length(); i++) {
							String jsonArrayString = jasonarray.get(i).toString();
							JSONObject innerjsonObject = new JSONObject(jsonArrayString);

							if (exists == false) {
								getkey(innerjsonObject, key);
							}
						}

					}
				} catch (Exception ex) {

				}

			}

		} else {
			parseObject(json, key);

		}

	}

	public static void main(String[] args) {
		String inputjson = "{\n" + 
				"    \"data\": {\n" + 
				"        \"article_parent\": {\n" + 
				"            \"about\": \"\",\n" + 
				"            \"active\": 1,\n" + 
				"            \"attributes\": [\n" + 
				"                {\n" + 
				"                    \"group_name\": \"Style\",\n" + 
				"                    \"name\": \"Pattern\",\n" + 
				"                    \"value\": \"Solid\"\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"group_name\": \"Clothing Details\",\n" + 
				"                    \"name\": \"Colour\",\n" + 
				"                    \"value\": \"Black\"\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"group_name\": \"Clothing Details\",\n" + 
				"                    \"name\": \"Gender\",\n" + 
				"                    \"value\": \"Men\"\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"group_name\": \"Style\",\n" + 
				"                    \"name\": \"Fit\",\n" + 
				"                    \"value\": \"Slim\"\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"group_name\": \"Clothing Details\",\n" + 
				"                    \"name\": \"Fabric\",\n" + 
				"                    \"value\": \"Cotton\"\n" + 
				"                },\n" + 
				"                {\n" + 
				"                    \"group_name\": \"Clothing Details\",\n" + 
				"                    \"name\": \"Occasion\",\n" + 
				"                    \"value\": \"Casual\"\n" + 
				"                }\n" + 
				"            ],\n" + 
				"            \"brand_id\": 387,\n" + 
				"            \"cancellable\": 1,\n" + 
				"            \"created_at\": \"2020-06-16T16:16:20.5459+05:30\",\n" + 
				"            \"deleted\": 0,\n" + 
				"            \"deleted_at\": null,\n" + 
				"            \"desc\": \"<ul><li>Blue DENIM Jeans</li><li>Fabric:Cotton Blend</li><li>Fit:Straight Slim</li><li>Waist Type:</li><li>Length:</li><li>Wash Care:MACHINE WASH</li><li>Product Code:50012616361BLACK</li></ul>\",\n" + 
				"            \"family\": \"50012616361\",\n" + 
				"            \"hierarchy_id\": 945,\n" + 
				"            \"id\": 10590,\n" + 
				"            \"images\": [\n" + 
				"                {\n" + 
				"                    \"height\": 1000,\n" + 
				"                    \"mime\": \"image/jpeg\",\n" + 
				"                    \"ref\": \"dAmDa7fnrl\",\n" + 
				"                    \"src\": \"catalog/article_parent/dAm/Da7/fnrl/50012616361013_1.jpg\",\n" + 
				"                    \"width\": 750\n" + 
				"                }\n" + 
				"            ],\n" + 
				"            \"info\": null,\n" + 
				"            \"jar\": {\n" + 
				"                \"article_information.category1\": [\n" + 
				"                    \"Fashion\"\n" + 
				"                ],\n" + 
				"                \"article_information.category2\": [\n" + 
				"                    \"Clothing\"\n" + 
				"                ],\n" + 
				"                \"article_information.category3\": [\n" + 
				"                    \"Bottomwear\"\n" + 
				"                ],\n" + 
				"                \"article_information.category4\": [\n" + 
				"                    \"Westernwear\"\n" + 
				"                ],\n" + 
				"                \"article_information.category5\": [\n" + 
				"                    \"Jeans & Jeggings\"\n" + 
				"                ],\n" + 
				"                \"article_information.category6\": [\n" + 
				"                    \"Jeans & Jeggings\"\n" + 
				"                ],\n" + 
				"                \"article_information.generic\": \"50012616361\",\n" + 
				"                \"article_information.variant\": \"50012616361BLACK\",\n" + 
				"                \"clothing_details.collection\": \"Core\",\n" + 
				"                \"clothing_details.colour\": \"Black\",\n" + 
				"                \"clothing_details.fabric\": \"Cotton\",\n" + 
				"                \"clothing_details.gender\": \"Men\",\n" + 
				"                \"clothing_details.lifestyle\": \"Casual\",\n" + 
				"                \"clothing_details.occasion\": \"Casual\",\n" + 
				"                \"clothing_details.seasons\": \"Core\",\n" + 
				"                \"clothing_details.specific_colour\": \"Blue\",\n" + 
				"                \"packaging_returns.package_contains\": \"1 CELIO Jeans\",\n" + 
				"                \"product_information.feature1\": \"Cotton Blend\",\n" + 
				"                \"product_information.feature2\": \"Cotton Blend\",\n" + 
				"                \"product_type.type\": \"Jeans\",\n" + 
				"                \"style.fit\": \"Slim\",\n" + 
				"                \"style.pattern\": \"Solid\"\n" + 
				"            },\n" + 
				"            \"machine_state\": \"created\",\n" + 
				"            \"mc_scode\": \"3617\",\n" + 
				"            \"name\": \"CELIO Jeans\",\n" + 
				"            \"portal_article_parent\": {\n" + 
				"                \"id\": 6352,\n" + 
				"                \"portal_id\": 103,\n" + 
				"                \"article_parent_id\": 10590,\n" + 
				"                \"portal_category_id\": 131,\n" + 
				"                \"additional_categories\": [\n" + 
				"                    179\n" + 
				"                ],\n" + 
				"                \"return_in\": 30,\n" + 
				"                \"cancellable\": 1,\n" + 
				"                \"seo\": null,\n" + 
				"                \"url\": \"/celio-jeans-2\",\n" + 
				"                \"active\": 1,\n" + 
				"                \"tags\": null,\n" + 
				"                \"created_at\": \"2020-06-16T19:20:23.6214+05:30\",\n" + 
				"                \"updated_at\": \"2020-07-24T14:25:35.3986+05:30\"\n" + 
				"            },\n" + 
				"            \"return_in\": 1,\n" + 
				"            \"seo\": null,\n" + 
				"            \"state_remarks\": null,\n" + 
				"            \"stated_at\": \"2020-06-16T16:16:20.5459+05:30\",\n" + 
				"            \"stock_measure_code\": \"unit\",\n" + 
				"            \"tags\": null,\n" + 
				"            \"uid\": \"KG7hxYkv\",\n" + 
				"            \"updated_at\": \"2020-06-25T11:37:00.327+05:30\",\n" + 
				"            \"url\": \"/celio-jeans-2\",\n" + 
				"            \"variant_group\": \"50012616361BLACK\"\n" + 
				"        },\n" + 
				"        \"articles\": [\n" + 
				"            {\n" + 
				"                \"about\": \"\",\n" + 
				"                \"active\": 1,\n" + 
				"                \"article_parent_id\": 10590,\n" + 
				"                \"attributes\": [\n" + 
				"                    {\n" + 
				"                        \"group_name\": \"Article Information\",\n" + 
				"                        \"name\": \"Size\",\n" + 
				"                        \"value\": \"38\"\n" + 
				"                    }\n" + 
				"                ],\n" + 
				"                \"availability\": {\n" + 
				"                    \"total_atp\": 1,\n" + 
				"                    \"stores\": null\n" + 
				"                },\n" + 
				"                \"created_at\": \"2020-06-16T16:16:20.5779+05:30\",\n" + 
				"                \"deleted\": 0,\n" + 
				"                \"deleted_at\": null,\n" + 
				"                \"desc\": \"<ul><li>Blue DENIM Jeans</li><li>Fabric:Cotton Blend</li><li>Fit:Straight Slim</li><li>Waist Type:</li><li>Length:</li><li>Wash Care:MACHINE WASH</li><li>Product Code:50012616361BLACK</li></ul>\",\n" + 
				"                \"eans\": null,\n" + 
				"                \"hsn\": \"6203\",\n" + 
				"                \"id\": 28085,\n" + 
				"                \"images\": null,\n" + 
				"                \"info\": null,\n" + 
				"                \"jar\": {\n" + 
				"                    \"article_information.barcode_ean\": \"8904231578869\",\n" + 
				"                    \"article_information.mc_code\": 3617,\n" + 
				"                    \"article_information.mc_description\": \"CT Mens Casual Jeans\",\n" + 
				"                    \"article_information.size\": \"38\"\n" + 
				"                },\n" + 
				"                \"machine_state\": \"created\",\n" + 
				"                \"material\": [\n" + 
				"                    \"normal\"\n" + 
				"                ],\n" + 
				"                \"name\": \"CELIO Jeans\",\n" + 
				"                \"pack_of\": 1,\n" + 
				"                \"package\": {\n" + 
				"                    \"breadth\": 0,\n" + 
				"                    \"height\": 0,\n" + 
				"                    \"length\": 0,\n" + 
				"                    \"weight\": 0\n" + 
				"                },\n" + 
				"                \"portal_article\": {\n" + 
				"                    \"id\": 15648,\n" + 
				"                    \"portal_id\": 103,\n" + 
				"                    \"article_id\": 28085,\n" + 
				"                    \"portal_article_parent_id\": 6352,\n" + 
				"                    \"min_qty\": 1,\n" + 
				"                    \"max_qty\": 10,\n" + 
				"                    \"group_parent\": 1,\n" + 
				"                    \"sale_start_at\": null,\n" + 
				"                    \"sale_end_at\": null,\n" + 
				"                    \"seo\": null,\n" + 
				"                    \"url\": \"/a/celio-jeans-12\",\n" + 
				"                    \"active\": 1,\n" + 
				"                    \"boost\": 0,\n" + 
				"                    \"tags\": null,\n" + 
				"                    \"created_at\": \"2020-06-16T19:20:23.6434+05:30\",\n" + 
				"                    \"updated_at\": \"2020-06-16T19:20:23.6434+05:30\"\n" + 
				"                },\n" + 
				"                \"prices\": [\n" + 
				"                    {\n" + 
				"                        \"mrp\": 30000,\n" + 
				"                        \"portal_id\": \"\",\n" + 
				"                        \"price\": 21400,\n" + 
				"                        \"store_scode\": \"0255\",\n" + 
				"                        \"updated_at\": \"2020-07-06T13:08:27.7776+05:30\"\n" + 
				"                    }\n" + 
				"                ],\n" + 
				"                \"prime_ean\": null,\n" + 
				"                \"prime_variant\": 0,\n" + 
				"                \"promotions\": {\n" + 
				"                    \"article_scode\": \"000050012616361013\",\n" + 
				"                    \"future_pay_offers\": [],\n" + 
				"                    \"product_offers\": []\n" + 
				"                },\n" + 
				"                \"qty_label\": \"1 unit\",\n" + 
				"                \"scode\": \"000050012616361013\",\n" + 
				"                \"seo\": null,\n" + 
				"                \"serviceability\": {\n" + 
				"                    \"serviceable\": false,\n" + 
				"                    \"standard_min\": 0,\n" + 
				"                    \"standard_max\": 0,\n" + 
				"                    \"express_min\": 0,\n" + 
				"                    \"express_max\": 0,\n" + 
				"                    \"stores\": null\n" + 
				"                },\n" + 
				"                \"state_remarks\": null,\n" + 
				"                \"stated_at\": \"2020-06-16T16:16:20.5779+05:30\",\n" + 
				"                \"tags\": null,\n" + 
				"                \"updated_at\": \"2020-06-16T16:16:20.5779+05:30\",\n" + 
				"                \"url\": \"/a/celio-jeans-10\",\n" + 
				"                \"variant_qty\": 1\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"about\": \"\",\n" + 
				"                \"active\": 1,\n" + 
				"                \"article_parent_id\": 10590,\n" + 
				"                \"attributes\": [\n" + 
				"                    {\n" + 
				"                        \"group_name\": \"Article Information\",\n" + 
				"                        \"name\": \"Size\",\n" + 
				"                        \"value\": \"40\"\n" + 
				"                    }\n" + 
				"                ],\n" + 
				"                \"availability\": {\n" + 
				"                    \"total_atp\": 1,\n" + 
				"                    \"stores\": null\n" + 
				"                },\n" + 
				"                \"created_at\": \"2020-06-16T16:16:20.6677+05:30\",\n" + 
				"                \"deleted\": 0,\n" + 
				"                \"deleted_at\": null,\n" + 
				"                \"desc\": \"<ul><li>Blue DENIM Jeans</li><li>Fabric:Cotton Blend</li><li>Fit:Straight Slim</li><li>Waist Type:</li><li>Length:</li><li>Wash Care:MACHINE WASH</li><li>Product Code:50012616361BLACK</li></ul>\",\n" + 
				"                \"eans\": null,\n" + 
				"                \"hsn\": \"6203\",\n" + 
				"                \"id\": 28086,\n" + 
				"                \"images\": null,\n" + 
				"                \"info\": null,\n" + 
				"                \"jar\": {\n" + 
				"                    \"article_information.barcode_ean\": \"8904231578876\",\n" + 
				"                    \"article_information.mc_code\": 3617,\n" + 
				"                    \"article_information.mc_description\": \"CT Mens Casual Jeans\",\n" + 
				"                    \"article_information.size\": \"40\"\n" + 
				"                },\n" + 
				"                \"machine_state\": \"created\",\n" + 
				"                \"material\": [\n" + 
				"                    \"normal\"\n" + 
				"                ],\n" + 
				"                \"name\": \"CELIO Jeans\",\n" + 
				"                \"pack_of\": 1,\n" + 
				"                \"package\": {\n" + 
				"                    \"breadth\": 0,\n" + 
				"                    \"height\": 0,\n" + 
				"                    \"length\": 0,\n" + 
				"                    \"weight\": 0\n" + 
				"                },\n" + 
				"                \"portal_article\": {\n" + 
				"                    \"id\": 15649,\n" + 
				"                    \"portal_id\": 103,\n" + 
				"                    \"article_id\": 28086,\n" + 
				"                    \"portal_article_parent_id\": 6352,\n" + 
				"                    \"min_qty\": 1,\n" + 
				"                    \"max_qty\": 10,\n" + 
				"                    \"group_parent\": 1,\n" + 
				"                    \"sale_start_at\": null,\n" + 
				"                    \"sale_end_at\": null,\n" + 
				"                    \"seo\": null,\n" + 
				"                    \"url\": \"/a/celio-jeans-13\",\n" + 
				"                    \"active\": 1,\n" + 
				"                    \"boost\": 0,\n" + 
				"                    \"tags\": null,\n" + 
				"                    \"created_at\": \"2020-06-16T19:20:23.6828+05:30\",\n" + 
				"                    \"updated_at\": \"2020-06-16T19:20:23.6828+05:30\"\n" + 
				"                },\n" + 
				"                \"prices\": [\n" + 
				"                    {\n" + 
				"                        \"mrp\": 30000,\n" + 
				"                        \"portal_id\": \"\",\n" + 
				"                        \"price\": 22900,\n" + 
				"                        \"store_scode\": \"0255\",\n" + 
				"                        \"updated_at\": \"2020-07-06T13:08:27.7776+05:30\"\n" + 
				"                    }\n" + 
				"                ],\n" + 
				"                \"prime_ean\": null,\n" + 
				"                \"prime_variant\": 0,\n" + 
				"                \"promotions\": {\n" + 
				"                    \"article_scode\": \"000050012616361014\",\n" + 
				"                    \"future_pay_offers\": [],\n" + 
				"                    \"product_offers\": []\n" + 
				"                },\n" + 
				"                \"qty_label\": \"1 unit\",\n" + 
				"                \"scode\": \"000050012616361014\",\n" + 
				"                \"seo\": null,\n" + 
				"                \"serviceability\": {\n" + 
				"                    \"serviceable\": false,\n" + 
				"                    \"standard_min\": 0,\n" + 
				"                    \"standard_max\": 0,\n" + 
				"                    \"express_min\": 0,\n" + 
				"                    \"express_max\": 0,\n" + 
				"                    \"stores\": null\n" + 
				"                },\n" + 
				"                \"state_remarks\": null,\n" + 
				"                \"stated_at\": \"2020-06-16T16:16:20.6677+05:30\",\n" + 
				"                \"tags\": null,\n" + 
				"                \"updated_at\": \"2020-06-16T16:16:20.6677+05:30\",\n" + 
				"                \"url\": \"/a/celio-jeans-11\",\n" + 
				"                \"variant_qty\": 1\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"about\": \"\",\n" + 
				"                \"active\": 1,\n" + 
				"                \"article_parent_id\": 10590,\n" + 
				"                \"attributes\": [\n" + 
				"                    {\n" + 
				"                        \"group_name\": \"Article Information\",\n" + 
				"                        \"name\": \"Size\",\n" + 
				"                        \"value\": \"42\"\n" + 
				"                    }\n" + 
				"                ],\n" + 
				"                \"availability\": {\n" + 
				"                    \"total_atp\": 1,\n" + 
				"                    \"stores\": null\n" + 
				"                },\n" + 
				"                \"created_at\": \"2020-06-16T16:16:20.7626+05:30\",\n" + 
				"                \"deleted\": 0,\n" + 
				"                \"deleted_at\": null,\n" + 
				"                \"desc\": \"<ul><li>Blue DENIM Jeans</li><li>Fabric:Cotton Blend</li><li>Fit:Straight Slim</li><li>Waist Type:</li><li>Length:</li><li>Wash Care:MACHINE WASH</li><li>Product Code:50012616361BLACK</li></ul>\",\n" + 
				"                \"eans\": null,\n" + 
				"                \"hsn\": \"6203\",\n" + 
				"                \"id\": 28087,\n" + 
				"                \"images\": null,\n" + 
				"                \"info\": null,\n" + 
				"                \"jar\": {\n" + 
				"                    \"article_information.barcode_ean\": \"8904231578883\",\n" + 
				"                    \"article_information.mc_code\": 3617,\n" + 
				"                    \"article_information.mc_description\": \"CT Mens Casual Jeans\",\n" + 
				"                    \"article_information.size\": \"42\"\n" + 
				"                },\n" + 
				"                \"machine_state\": \"created\",\n" + 
				"                \"material\": [\n" + 
				"                    \"normal\"\n" + 
				"                ],\n" + 
				"                \"name\": \"CELIO Jeans\",\n" + 
				"                \"pack_of\": 1,\n" + 
				"                \"package\": {\n" + 
				"                    \"breadth\": 0,\n" + 
				"                    \"height\": 0,\n" + 
				"                    \"length\": 0,\n" + 
				"                    \"weight\": 0\n" + 
				"                },\n" + 
				"                \"portal_article\": {\n" + 
				"                    \"id\": 15650,\n" + 
				"                    \"portal_id\": 103,\n" + 
				"                    \"article_id\": 28087,\n" + 
				"                    \"portal_article_parent_id\": 6352,\n" + 
				"                    \"min_qty\": 1,\n" + 
				"                    \"max_qty\": 10,\n" + 
				"                    \"group_parent\": 1,\n" + 
				"                    \"sale_start_at\": null,\n" + 
				"                    \"sale_end_at\": null,\n" + 
				"                    \"seo\": null,\n" + 
				"                    \"url\": \"/a/celio-jeans-14\",\n" + 
				"                    \"active\": 1,\n" + 
				"                    \"boost\": 0,\n" + 
				"                    \"tags\": null,\n" + 
				"                    \"created_at\": \"2020-06-16T19:20:23.7158+05:30\",\n" + 
				"                    \"updated_at\": \"2020-06-16T19:20:23.7158+05:30\"\n" + 
				"                },\n" + 
				"                \"prices\": [\n" + 
				"                    {\n" + 
				"                        \"mrp\": 30000,\n" + 
				"                        \"portal_id\": \"\",\n" + 
				"                        \"price\": 25800,\n" + 
				"                        \"store_scode\": \"0255\",\n" + 
				"                        \"updated_at\": \"2020-07-06T13:08:27.7776+05:30\"\n" + 
				"                    }\n" + 
				"                ],\n" + 
				"                \"prime_ean\": null,\n" + 
				"                \"prime_variant\": 0,\n" + 
				"                \"promotions\": {\n" + 
				"                    \"article_scode\": \"000050012616361015\",\n" + 
				"                    \"future_pay_offers\": [],\n" + 
				"                    \"product_offers\": []\n" + 
				"                },\n" + 
				"                \"qty_label\": \"1 unit\",\n" + 
				"                \"scode\": \"000050012616361015\",\n" + 
				"                \"seo\": null,\n" + 
				"                \"serviceability\": {\n" + 
				"                    \"serviceable\": false,\n" + 
				"                    \"standard_min\": 0,\n" + 
				"                    \"standard_max\": 0,\n" + 
				"                    \"express_min\": 0,\n" + 
				"                    \"express_max\": 0,\n" + 
				"                    \"stores\": null\n" + 
				"                },\n" + 
				"                \"state_remarks\": null,\n" + 
				"                \"stated_at\": \"2020-06-16T16:16:20.7626+05:30\",\n" + 
				"                \"tags\": null,\n" + 
				"                \"updated_at\": \"2020-06-16T16:16:20.7626+05:30\",\n" + 
				"                \"url\": \"/a/celio-jeans-12\",\n" + 
				"                \"variant_qty\": 1\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"about\": \"\",\n" + 
				"                \"active\": 1,\n" + 
				"                \"article_parent_id\": 10590,\n" + 
				"                \"attributes\": [\n" + 
				"                    {\n" + 
				"                        \"group_name\": \"Article Information\",\n" + 
				"                        \"name\": \"Size\",\n" + 
				"                        \"value\": \"44\"\n" + 
				"                    }\n" + 
				"                ],\n" + 
				"                \"availability\": {\n" + 
				"                    \"total_atp\": 1,\n" + 
				"                    \"stores\": null\n" + 
				"                },\n" + 
				"                \"created_at\": \"2020-06-16T16:16:20.8827+05:30\",\n" + 
				"                \"deleted\": 0,\n" + 
				"                \"deleted_at\": null,\n" + 
				"                \"desc\": \"<ul><li>Blue DENIM Jeans</li><li>Fabric:Cotton Blend</li><li>Fit:Straight Slim</li><li>Waist Type:</li><li>Length:</li><li>Wash Care:MACHINE WASH</li><li>Product Code:50012616361BLACK</li></ul>\",\n" + 
				"                \"eans\": null,\n" + 
				"                \"hsn\": \"6203\",\n" + 
				"                \"id\": 28088,\n" + 
				"                \"images\": null,\n" + 
				"                \"info\": null,\n" + 
				"                \"jar\": {\n" + 
				"                    \"article_information.barcode_ean\": \"8904231578890\",\n" + 
				"                    \"article_information.mc_code\": 3617,\n" + 
				"                    \"article_information.mc_description\": \"CT Mens Casual Jeans\",\n" + 
				"                    \"article_information.size\": \"44\"\n" + 
				"                },\n" + 
				"                \"machine_state\": \"created\",\n" + 
				"                \"material\": [\n" + 
				"                    \"normal\"\n" + 
				"                ],\n" + 
				"                \"name\": \"CELIO Jeans\",\n" + 
				"                \"pack_of\": 1,\n" + 
				"                \"package\": {\n" + 
				"                    \"breadth\": 0,\n" + 
				"                    \"height\": 0,\n" + 
				"                    \"length\": 0,\n" + 
				"                    \"weight\": 0\n" + 
				"                },\n" + 
				"                \"portal_article\": {\n" + 
				"                    \"id\": 15651,\n" + 
				"                    \"portal_id\": 103,\n" + 
				"                    \"article_id\": 28088,\n" + 
				"                    \"portal_article_parent_id\": 6352,\n" + 
				"                    \"min_qty\": 1,\n" + 
				"                    \"max_qty\": 10,\n" + 
				"                    \"group_parent\": 1,\n" + 
				"                    \"sale_start_at\": null,\n" + 
				"                    \"sale_end_at\": null,\n" + 
				"                    \"seo\": null,\n" + 
				"                    \"url\": \"/a/celio-jeans-15\",\n" + 
				"                    \"active\": 1,\n" + 
				"                    \"boost\": 0,\n" + 
				"                    \"tags\": null,\n" + 
				"                    \"created_at\": \"2020-06-16T19:20:23.7493+05:30\",\n" + 
				"                    \"updated_at\": \"2020-06-16T19:20:23.7493+05:30\"\n" + 
				"                },\n" + 
				"                \"prices\": [\n" + 
				"                    {\n" + 
				"                        \"mrp\": 30000,\n" + 
				"                        \"portal_id\": \"\",\n" + 
				"                        \"price\": 24700,\n" + 
				"                        \"store_scode\": \"0255\",\n" + 
				"                        \"updated_at\": \"2020-07-06T13:08:27.7776+05:30\"\n" + 
				"                    }\n" + 
				"                ],\n" + 
				"                \"prime_ean\": null,\n" + 
				"                \"prime_variant\": 0,\n" + 
				"                \"promotions\": {\n" + 
				"                    \"article_scode\": \"000050012616361016\",\n" + 
				"                    \"future_pay_offers\": [],\n" + 
				"                    \"product_offers\": []\n" + 
				"                },\n" + 
				"                \"qty_label\": \"1 unit\",\n" + 
				"                \"scode\": \"000050012616361016\",\n" + 
				"                \"seo\": null,\n" + 
				"                \"serviceability\": {\n" + 
				"                    \"serviceable\": false,\n" + 
				"                    \"standard_min\": 0,\n" + 
				"                    \"standard_max\": 0,\n" + 
				"                    \"express_min\": 0,\n" + 
				"                    \"express_max\": 0,\n" + 
				"                    \"stores\": null\n" + 
				"                },\n" + 
				"                \"state_remarks\": null,\n" + 
				"                \"stated_at\": \"2020-06-16T16:16:20.8827+05:30\",\n" + 
				"                \"tags\": null,\n" + 
				"                \"updated_at\": \"2020-06-16T16:16:20.8827+05:30\",\n" + 
				"                \"url\": \"/a/celio-jeans-13\",\n" + 
				"                \"variant_qty\": 1\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"about\": \"\",\n" + 
				"                \"active\": 1,\n" + 
				"                \"article_parent_id\": 10590,\n" + 
				"                \"attributes\": [\n" + 
				"                    {\n" + 
				"                        \"group_name\": \"Article Information\",\n" + 
				"                        \"name\": \"Size\",\n" + 
				"                        \"value\": \"46\"\n" + 
				"                    }\n" + 
				"                ],\n" + 
				"                \"availability\": {\n" + 
				"                    \"total_atp\": 1,\n" + 
				"                    \"stores\": null\n" + 
				"                },\n" + 
				"                \"created_at\": \"2020-06-16T16:16:20.9823+05:30\",\n" + 
				"                \"deleted\": 0,\n" + 
				"                \"deleted_at\": null,\n" + 
				"                \"desc\": \"<ul><li>Blue DENIM Jeans</li><li>Fabric:Cotton Blend</li><li>Fit:Straight Slim</li><li>Waist Type:</li><li>Length:</li><li>Wash Care:MACHINE WASH</li><li>Product Code:50012616361BLACK</li></ul>\",\n" + 
				"                \"eans\": null,\n" + 
				"                \"hsn\": \"6203\",\n" + 
				"                \"id\": 28089,\n" + 
				"                \"images\": null,\n" + 
				"                \"info\": null,\n" + 
				"                \"jar\": {\n" + 
				"                    \"article_information.barcode_ean\": \"8904231578906\",\n" + 
				"                    \"article_information.mc_code\": 3617,\n" + 
				"                    \"article_information.mc_description\": \"CT Mens Casual Jeans\",\n" + 
				"                    \"article_information.size\": \"46\"\n" + 
				"                },\n" + 
				"                \"machine_state\": \"created\",\n" + 
				"                \"material\": [\n" + 
				"                    \"normal\"\n" + 
				"                ],\n" + 
				"                \"name\": \"CELIO Jeans\",\n" + 
				"                \"pack_of\": 1,\n" + 
				"                \"package\": {\n" + 
				"                    \"breadth\": 0,\n" + 
				"                    \"height\": 0,\n" + 
				"                    \"length\": 0,\n" + 
				"                    \"weight\": 0\n" + 
				"                },\n" + 
				"                \"portal_article\": {\n" + 
				"                    \"id\": 15652,\n" + 
				"                    \"portal_id\": 103,\n" + 
				"                    \"article_id\": 28089,\n" + 
				"                    \"portal_article_parent_id\": 6352,\n" + 
				"                    \"min_qty\": 1,\n" + 
				"                    \"max_qty\": 10,\n" + 
				"                    \"group_parent\": 1,\n" + 
				"                    \"sale_start_at\": \"2020-06-25T11:40:31+05:30\",\n" + 
				"                    \"sale_end_at\": null,\n" + 
				"                    \"seo\": null,\n" + 
				"                    \"url\": \"/a/celio-jeans-16\",\n" + 
				"                    \"active\": 1,\n" + 
				"                    \"boost\": 0,\n" + 
				"                    \"tags\": null,\n" + 
				"                    \"created_at\": \"2020-06-16T19:20:23.7865+05:30\",\n" + 
				"                    \"updated_at\": \"2020-06-25T11:36:47.2576+05:30\"\n" + 
				"                },\n" + 
				"                \"prices\": [\n" + 
				"                    {\n" + 
				"                        \"mrp\": 30000,\n" + 
				"                        \"portal_id\": \"\",\n" + 
				"                        \"price\": 23600,\n" + 
				"                        \"store_scode\": \"0255\",\n" + 
				"                        \"updated_at\": \"2020-07-06T13:08:27.7776+05:30\"\n" + 
				"                    }\n" + 
				"                ],\n" + 
				"                \"prime_ean\": null,\n" + 
				"                \"prime_variant\": 0,\n" + 
				"                \"promotions\": {\n" + 
				"                    \"article_scode\": \"000050012616361017\",\n" + 
				"                    \"future_pay_offers\": [],\n" + 
				"                    \"product_offers\": []\n" + 
				"                },\n" + 
				"                \"qty_label\": \"1 unit\",\n" + 
				"                \"scode\": \"000050012616361017\",\n" + 
				"                \"seo\": null,\n" + 
				"                \"serviceability\": {\n" + 
				"                    \"serviceable\": false,\n" + 
				"                    \"standard_min\": 0,\n" + 
				"                    \"standard_max\": 0,\n" + 
				"                    \"express_min\": 0,\n" + 
				"                    \"express_max\": 0,\n" + 
				"                    \"stores\": null\n" + 
				"                },\n" + 
				"                \"state_remarks\": null,\n" + 
				"                \"stated_at\": \"2020-06-16T16:16:20.9823+05:30\",\n" + 
				"                \"tags\": null,\n" + 
				"                \"updated_at\": \"2020-06-16T16:16:20.9823+05:30\",\n" + 
				"                \"url\": \"/a/celio-jeans-14\",\n" + 
				"                \"variant_qty\": 1\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"about\": \"\",\n" + 
				"                \"active\": 1,\n" + 
				"                \"article_parent_id\": 10590,\n" + 
				"                \"attributes\": [\n" + 
				"                    {\n" + 
				"                        \"group_name\": \"Article Information\",\n" + 
				"                        \"name\": \"Size\",\n" + 
				"                        \"value\": \"48\"\n" + 
				"                    }\n" + 
				"                ],\n" + 
				"                \"availability\": {\n" + 
				"                    \"total_atp\": 1,\n" + 
				"                    \"stores\": null\n" + 
				"                },\n" + 
				"                \"created_at\": \"2020-06-16T16:28:21.3312+05:30\",\n" + 
				"                \"deleted\": 0,\n" + 
				"                \"deleted_at\": null,\n" + 
				"                \"desc\": \"<ul><li>Blue DENIM Jeans</li><li>Fabric:Cotton Blend</li><li>Fit:Straight Slim</li><li>Waist Type:</li><li>Length:</li><li>Wash Care:MACHINE WASH</li><li>Product Code:50012616361BLACK</li></ul>\",\n" + 
				"                \"eans\": null,\n" + 
				"                \"hsn\": \"6203\",\n" + 
				"                \"id\": 28121,\n" + 
				"                \"images\": null,\n" + 
				"                \"info\": null,\n" + 
				"                \"jar\": {\n" + 
				"                    \"article_information.barcode_ean\": \"8904231578913\",\n" + 
				"                    \"article_information.mc_code\": 3617,\n" + 
				"                    \"article_information.mc_description\": \"CT Mens Casual Jeans\",\n" + 
				"                    \"article_information.size\": \"48\"\n" + 
				"                },\n" + 
				"                \"machine_state\": \"created\",\n" + 
				"                \"material\": [\n" + 
				"                    \"normal\"\n" + 
				"                ],\n" + 
				"                \"name\": \"CELIO Jeans\",\n" + 
				"                \"pack_of\": 1,\n" + 
				"                \"package\": {\n" + 
				"                    \"breadth\": 0,\n" + 
				"                    \"height\": 0,\n" + 
				"                    \"length\": 0,\n" + 
				"                    \"weight\": 0\n" + 
				"                },\n" + 
				"                \"portal_article\": {\n" + 
				"                    \"id\": 15653,\n" + 
				"                    \"portal_id\": 103,\n" + 
				"                    \"article_id\": 28121,\n" + 
				"                    \"portal_article_parent_id\": 6352,\n" + 
				"                    \"min_qty\": 1,\n" + 
				"                    \"max_qty\": 10,\n" + 
				"                    \"group_parent\": 1,\n" + 
				"                    \"sale_start_at\": null,\n" + 
				"                    \"sale_end_at\": null,\n" + 
				"                    \"seo\": null,\n" + 
				"                    \"url\": \"/a/celio-jeans-17\",\n" + 
				"                    \"active\": 1,\n" + 
				"                    \"boost\": 0,\n" + 
				"                    \"tags\": null,\n" + 
				"                    \"created_at\": \"2020-06-16T19:20:23.8215+05:30\",\n" + 
				"                    \"updated_at\": \"2020-06-16T19:20:23.8215+05:30\"\n" + 
				"                },\n" + 
				"                \"prices\": [\n" + 
				"                    {\n" + 
				"                        \"mrp\": 30000,\n" + 
				"                        \"portal_id\": \"\",\n" + 
				"                        \"price\": 21700,\n" + 
				"                        \"store_scode\": \"0255\",\n" + 
				"                        \"updated_at\": \"2020-07-06T13:08:27.7776+05:30\"\n" + 
				"                    }\n" + 
				"                ],\n" + 
				"                \"prime_ean\": null,\n" + 
				"                \"prime_variant\": 0,\n" + 
				"                \"promotions\": {\n" + 
				"                    \"article_scode\": \"000050012616361018\",\n" + 
				"                    \"future_pay_offers\": [],\n" + 
				"                    \"product_offers\": []\n" + 
				"                },\n" + 
				"                \"qty_label\": \"1 unit\",\n" + 
				"                \"scode\": \"000050012616361018\",\n" + 
				"                \"seo\": null,\n" + 
				"                \"serviceability\": {\n" + 
				"                    \"serviceable\": false,\n" + 
				"                    \"standard_min\": 0,\n" + 
				"                    \"standard_max\": 0,\n" + 
				"                    \"express_min\": 0,\n" + 
				"                    \"express_max\": 0,\n" + 
				"                    \"stores\": null\n" + 
				"                },\n" + 
				"                \"state_remarks\": null,\n" + 
				"                \"stated_at\": \"2020-06-16T16:28:21.3312+05:30\",\n" + 
				"                \"tags\": null,\n" + 
				"                \"updated_at\": \"2020-06-16T16:28:21.3312+05:30\",\n" + 
				"                \"url\": \"/a/celio-jeans-26\",\n" + 
				"                \"variant_qty\": 1\n" + 
				"            }\n" + 
				"        ],\n" + 
				"        \"brand\": {\n" + 
				"            \"about\": \"\",\n" + 
				"            \"active\": 1,\n" + 
				"            \"created_at\": \"2020-06-16T15:15:07.0637+05:30\",\n" + 
				"            \"deleted\": 0,\n" + 
				"            \"deleted_at\": null,\n" + 
				"            \"desc\": \"\",\n" + 
				"            \"id\": 387,\n" + 
				"            \"image\": null,\n" + 
				"            \"info\": null,\n" + 
				"            \"name\": \"CELIO\",\n" + 
				"            \"portal_brand\": {\n" + 
				"                \"id\": 352,\n" + 
				"                \"portal_id\": 103,\n" + 
				"                \"name\": \"CELIO\",\n" + 
				"                \"boost\": 0,\n" + 
				"                \"active\": 1,\n" + 
				"                \"sequence\": 1,\n" + 
				"                \"seo\": null,\n" + 
				"                \"url\": \"/b/celio\",\n" + 
				"                \"tags\": null,\n" + 
				"                \"info\": null,\n" + 
				"                \"deleted\": 0,\n" + 
				"                \"deleted_at\": null,\n" + 
				"                \"created_at\": \"2020-06-16T19:20:18.5968+05:30\",\n" + 
				"                \"updated_at\": \"2020-06-16T19:20:18.5968+05:30\"\n" + 
				"            },\n" + 
				"            \"scode\": \"celio\",\n" + 
				"            \"seo\": null,\n" + 
				"            \"tags\": [],\n" + 
				"            \"updated_at\": \"2020-06-16T15:15:07.0637+05:30\",\n" + 
				"            \"url\": \"/b/celio\"\n" + 
				"        },\n" + 
				"        \"family\": [\n" + 
				"            {\n" + 
				"                \"article_parent_id\": 10590,\n" + 
				"                \"articles\": [\n" + 
				"                    \"000050012616361013\",\n" + 
				"                    \"000050012616361014\",\n" + 
				"                    \"000050012616361015\",\n" + 
				"                    \"000050012616361016\",\n" + 
				"                    \"000050012616361017\",\n" + 
				"                    \"000050012616361018\",\n" + 
				"                    \"000050012616361013\",\n" + 
				"                    \"000050012616361014\",\n" + 
				"                    \"000050012616361015\",\n" + 
				"                    \"000050012616361016\",\n" + 
				"                    \"000050012616361017\",\n" + 
				"                    \"000050012616361018\"\n" + 
				"                ],\n" + 
				"                \"color\": \"Black\",\n" + 
				"                \"images\": [\n" + 
				"                    {\n" + 
				"                        \"ref\": \"dAmDa7fnrl\",\n" + 
				"                        \"src\": \"catalog/article_parent/dAm/Da7/fnrl/50012616361013_1.jpg\",\n" + 
				"                        \"mime\": \"image/jpeg\",\n" + 
				"                        \"width\": 750,\n" + 
				"                        \"height\": 1000\n" + 
				"                    }\n" + 
				"                ],\n" + 
				"                \"name\": \"CELIO Jeans\"\n" + 
				"            },\n" + 
				"            {\n" + 
				"                \"article_parent_id\": 10591,\n" + 
				"                \"articles\": [\n" + 
				"                    \"000050012616361019\",\n" + 
				"                    \"000050012616361020\",\n" + 
				"                    \"000050012616361021\",\n" + 
				"                    \"000050012616361022\",\n" + 
				"                    \"000050012616361023\",\n" + 
				"                    \"000050012616361024\",\n" + 
				"                    \"000050012616361019\",\n" + 
				"                    \"000050012616361020\",\n" + 
				"                    \"000050012616361021\",\n" + 
				"                    \"000050012616361022\",\n" + 
				"                    \"000050012616361023\",\n" + 
				"                    \"000050012616361024\"\n" + 
				"                ],\n" + 
				"                \"color\": \"Blue\",\n" + 
				"                \"images\": null,\n" + 
				"                \"name\": \"CELIO Jeans\"\n" + 
				"            }\n" + 
				"        ],\n" + 
				"        \"portal_category\": {\n" + 
				"            \"active\": 1,\n" + 
				"            \"created_at\": \"2020-05-25T12:55:36.5718+05:30\",\n" + 
				"            \"deleted\": 0,\n" + 
				"            \"deleted_at\": null,\n" + 
				"            \"desc\": \"\",\n" + 
				"            \"display_end_at\": null,\n" + 
				"            \"display_start_at\": null,\n" + 
				"            \"icon\": null,\n" + 
				"            \"id\": 131,\n" + 
				"            \"images\": [\n" + 
				"                {\n" + 
				"                    \"height\": 268,\n" + 
				"                    \"mime\": \"image/png\",\n" + 
				"                    \"ref\": \"yd7X8v4Ocl\",\n" + 
				"                    \"src\": \"catalog/portal_category/yd7/X8v/4Ocl/DENIMS.png\",\n" + 
				"                    \"width\": 268\n" + 
				"                }\n" + 
				"            ],\n" + 
				"            \"info\": null,\n" + 
				"            \"level\": 3,\n" + 
				"            \"name\": \"Denims\",\n" + 
				"            \"parent_id\": 124,\n" + 
				"            \"path\": [\n" + 
				"                63,\n" + 
				"                105,\n" + 
				"                124\n" + 
				"            ],\n" + 
				"            \"portal_id\": 103,\n" + 
				"            \"seo\": null,\n" + 
				"            \"sequence\": 1,\n" + 
				"            \"tags\": [],\n" + 
				"            \"ui_type\": null,\n" + 
				"            \"updated_at\": \"2020-06-24T00:09:12.0348+05:30\",\n" + 
				"            \"url\": \"/c/denims\",\n" + 
				"            \"visible\": 1\n" + 
				"        },\n" + 
				"        \"sold_out\": false\n" + 
				"    },\n" + 
				"    \"success\": true,\n" + 
				"    \"errors\": null\n" + 
				"}";
		JSONObject inputjsonObject = new JSONObject(inputjson);

		getkey(inputjsonObject, "mrp");
	}

}
