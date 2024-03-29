import colourtag.Colour
import colourtag.Season
import colourtag.Tone
import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->

        JSON.registerObjectMarshaller(Tone) { Tone tone ->
            return [
                    tone.toString(),
            ]
        }
        JSON.registerObjectMarshaller(Season) { Season season ->
            return [
                    season.toString(),
            ]
        }

        def allcolors = [
                [1, 1, 'Blue Red', '19-1762', '#AD1C42', 4, 5, '1.jpg'],
                [1, 1, 'Blue Red', '19-1762', '#AD1C42', 4, 3, '1.jpg'],
                [1, 1, 'Blue Red', '19-1762', '#AD1C42', 4, 2, '1.jpg'],
                [2, 2, 'Light Blue Red', '18-1852', '#c21e56', 2, 5, '2.jpg'],
                [2, 2, 'Light Blue Red', '18-1852', '#c21e56', 2, 1, '2.jpg'],
                [3, 3, 'Dark True Red', '19-1664', '#bc243c', 4, 5, '3.jpg'],
                [3, 3, 'Dark True Red', '19-1664', '#bc243c', 4, 2, '3.jpg'],
                [3, 3, 'Dark True Red', '19-1664', '#bc243c', 4, 3, '3.jpg'],
                [4, 4, 'True Red', '19-1764', '#C52242', 4, 5, '4.jpg'],
                [4, 4, 'True Red', '19-1764', '#C52242', 4, 3, '4.jpg'],
                [5, 5, 'Clear Bright Red', '18-1660', '#E5003C', 1, 6, '5.jpg'],
                [5, 5, 'Clear Bright Red', '18-1660', '#E5003C', 1, 3, '5.jpg'],
                [6, 6, 'Mango', '17-1755', '#E63E62', 1, 1, '6.jpg'],
                [6, 6, 'Mango', '17-1755', '#E63E62', 1, 3, '6.jpg'],
                [6, 6, 'Mango', '17-1755', '#E63E62', 1, 6, '6.jpg'],
                [7, 7, 'Deep Rose', '17-1740', '#C14A64', 2, 5, '7.jpg'],
                [7, 7, 'Deep Rose', '17-1740', '#C14A64', 2, 1, '7.jpg'],
                [7, 7, 'Deep Rose', '17-1740', '#C14A64', 2, 4, '7.jpg'],
                [8, 8, 'Watermelon Red', '18-1643', '#A53E4B', 2, 5, '8.jpg'],
                [8, 8, 'Watermelon Red', '18-1643', '#A53E4B', 2, 4, '8.jpg'],
                [8, 8, 'Watermelon Red', '18-1643', '#A53E4B', 2, 1, '8.jpg'],
                [9, 9, 'Orange Red', '18-1662', '#DB3844', 1, 6, '9.jpg'],
                [9, 9, 'Orange Red', '18-1662', '#DB3844', 1, 1, '9.jpg'],
                [10, 10, 'Bright Orange Red', '17-1664', '#d2232c', 3, 2, '10.jpg'],
                [10, 10, 'Bright Orange Red', '17-1664', '#d2232c', 3, 3, '10.jpg'],
                [10, 10, 'Bright Orange Red', '17-1664', '#d2232c', 3, 6, '10.jpg'],
                [11, 11, 'Bittersweet', '19-1760', '#B52C45', 3, 2, '11.jpg'],
                [11, 11, 'Bittersweet', '19-1760', '#B52C45', 3, 6, '11.jpg'],
                [12, 12, 'Deep Tomato Red', '18-1655', '#BC2A3A', 3, 6, '12.jpg'],
                [12, 12, 'Deep Tomato Red', '18-1655', '#BC2A3A', 3, 4, '12.jpg'],
                [12, 12, 'Deep Tomato Red', '18-1655', '#BC2A3A', 3, 2, '12.jpg'],
                [13, 13, 'Pumpkin', '15-1153', '#F2932E', 3, 2, '13.jpg'],
                [13, 13, 'Pumpkin', '15-1153', '#F2932E', 3, 6, '13.jpg'],
                [14, 14, 'Mustard', '15-1142', '#D5A149', 3, 6, '14.jpg'],
                [14, 14, 'Mustard', '15-1142', '#D5A149', 3, 2, '14.jpg'],
                [14, 14, 'Mustard', '15-1142', '#D5A149', 3, 4, '14.jpg'],
                [15, 15, 'Gold', '15-1234', '#E09D66', 3, 4, '15.jpg'],
                [15, 15, 'Gold', '15-1234', '#E09D66', 3, 6, '15.jpg'],
                [16, 16, 'Yellow Gold', '14-0850', '#FFC849', 3, 2, '16.jpg'],
                [16, 16, 'Yellow Gold', '14-0850', '#FFC849', 3, 6, '16.jpg'],
                [17, 17, 'Bright Yellow', '12-0736', '#F8D974', 1, 2, '17.jpg'],
                [17, 17, 'Bright Yellow', '12-0736', '#F8D974', 1, 5, '17.jpg'],
                [17, 17, 'Bright Yellow', '12-0736', '#F8D974', 1, 3, '17.jpg'],
                [18, 18, 'Light Clear Gold', '13-0940', '#FAC668', 1, 1, '18.jpg'],
                [18, 18, 'Light Clear Gold', '13-0940', '#FAC668', 1, 6, '18.jpg'],
                [18, 18, 'Light Clear Gold', '13-0940', '#FAC668', 1, 3, '18.jpg'],
                [19, 19, 'Buff', '12-0824', '#F9E397', 1, 6, '19.jpg'],
                [19, 19, 'Buff', '12-0824', '#F9E397', 1, 1, '19.jpg'],
                [19, 19, 'Buff', '12-0824', '#F9E397', 1, 3, '19.jpg'],
                [20, 20, 'Bright Lemon Yellow', '12-0752', '#FBE337', 4, 2, '20.jpg'],
                [20, 20, 'Bright Lemon Yellow', '12-0752', '#FBE337', 1, 3, '20.jpg'],
                [20, 20, 'Bright Lemon Yellow', '12-0752', '#FBE337', 4, 3, '20.jpg'],
                [20, 20, 'Bright Lemon Yellow', '12-0752', '#FBE337', 1, 5, '20.jpg'],
                [20, 20, 'Bright Lemon Yellow', '12-0752', '#FBE337', 4, 5, '20.jpg'],
                [20, 20, 'Bright Lemon Yellow', '12-0752', '#FBE337', 1, 2, '20.jpg'],
                [21, 21, 'Lemon Yellow', '12-0740', '#F3ED7C', 4, 3, '21.jpg'],
                [21, 21, 'Lemon Yellow', '12-0740', '#F3ED7C', 4, 2, '21.jpg'],
                [21, 21, 'Lemon Yellow', '12-0740', '#F3ED7C', 4, 5, '21.jpg'],
                [22, 22, 'Light Lemon Yellow', '12-0727', '#FDE182', 2, 1, '22.jpg'],
                [22, 22, 'Light Lemon Yellow', '12-0727', '#FDE182', 2, 5, '22.jpg'],
                [23, 23, 'Icy Yellow', '11-0507 ', '#F2EDD8', 4, 5, '23.jpg'],
                [24, 24, 'Pastel Yellow Green', '12-0435', '#CCD97A', 1, 6, '24.jpg'],
                [24, 24, 'Pastel Yellow Green', '12-0435', '#CCD97A', 1, 3, '24.jpg'],
                [24, 24, 'Pastel Yellow Green', '12-0435', '#CCD97A', 1, 1, '24.jpg'],
                [25, 25, 'Navy Blue', '19-4023', '#373E4B', 4, 5, '25.jpg'],
                [25, 25, 'Navy Blue', '19-4023', '#373E4B', 4, 3, '25.jpg'],
                [25, 25, 'Navy Blue', '19-4023', '#373E4B', 4, 2, '25.jpg'],
                [26, 26, 'Grey Navy', '19-3928', '#485470', 2, 1, '26.jpg'],
                [26, 26, 'Grey Navy', '19-3928', '#485470', 2, 4, '26.jpg'],
                [26, 26, 'Grey Navy', '19-3928', '#485470', 2, 5, '26.jpg'],
                [27, 27, 'Marine Navy', '19-4125', '#274357', 3, 6, '27.jpg'],
                [27, 27, 'Marine Navy', '19-4125', '#274357', 3, 4, '27.jpg'],
                [27, 27, 'Marine Navy', '19-4125', '#274357', 3, 2, '27.jpg'],
                [28, 28, 'Light Clear Navy', '19-4044', '#2C4578', 1, 1, '28.jpg'],
                [28, 28, 'Light Clear Navy', '19-4044', '#2C4578', 1, 3, '28.jpg'],
                [29, 29, 'Royal Blue', '19-3864', '#323F7A', 4, 2, '29.jpg'],
                [29, 29, 'Royal Blue', '19-3864', '#323F7A', 4, 5, '29.jpg'],
                [29, 29, 'Royal Blue', '19-3864', '#323F7A', 4, 3, '29.jpg'],
                [30, 30, 'Dark Periwinkle', '19-3936', '#4C4E77', 3, 2, '30.jpg'],
                [30, 30, 'Dark Periwinkle', '19-3936', '#4C4E77', 3, 6, '30.jpg'],
                [31, 31, 'Bright Periwinkle Blue', '19-3850', '#4E468B', 1, 6, '31.jpg'],
                [31, 31, 'Bright Periwinkle Blue', '19-3850', '#4E468B', 1, 3, '31.jpg'],
                [31, 31, 'Bright Periwinkle Blue', '19-3850', '#4E468B', 1, 1, '31.jpg'],
                [32, 32, 'Medium Blue', '18-3935', '#657BB8', 2, 1, '32.jpg'],
                [33, 33, 'True Blue', '18-4148', '#155DA4', 4, 5, '33.jpg'],
                [33, 33, 'True Blue', '18-4148', '#155DA4', 4, 3, '33.jpg'],
                [33, 33, 'True Blue', '18-4148', '#155DA4', 4, 2, '33.jpg'],
                [34, 34, 'Light True Blue', '18-4039', '#4D7CBC', 1, 3, '34.jpg'],
                [34, 34, 'Light True Blue', '18-4039', '#4D7CBC', 1, 1, '34.jpg'],
                [35, 35, 'Charcoal Blue Grey', '18-4018', '#405e74 ', 2, 4, '35.jpg'],
                [35, 35, 'Charcoal Blue Grey', '18-4018', '#405e74 ', 2, 1, '35.jpg'],
                [35, 35, 'Charcoal Blue Grey', '18-4018', '#405e74 ', 2, 5, '35.jpg'],
                [36, 36, 'Grey Blue', '18-3918', '#53677A', 2, 1, '36.jpg'],
                [36, 36, 'Grey Blue', '18-3918', '#53677A', 2, 5, '36.jpg'],
                [36, 36, 'Grey Blue', '18-3918', '#53677A', 2, 4, '36.jpg'],
                [37, 37, 'Royal Purple', '19-3215', '#503E5C', 4, 2, '37.jpg'],
                [37, 37, 'Royal Purple', '19-3215', '#503E5C', 4, 5, '37.jpg'],
                [37, 37, 'Royal Purple', '19-3215', '#503E5C', 4, 3, '37.jpg'],
                [38, 38, 'Muted Violet', '18-3418', '#856088', 3, 1, '38.jpg'],
                [38, 38, 'Muted Violet', '18-3418', '#856088', 3, 4, '38.jpg'],
                [39, 39, 'Purple', '19-3737', '#513B75', 3, 6, '39.jpg'],
                [39, 39, 'Purple', '19-3737', '#513B75', 3, 2, '39.jpg'],
                [40, 40, 'Medium Violet', '18-3737', '#6D579A', 1, 1, '40.jpg'],
                [40, 40, 'Medium Violet', '18-3737', '#6D579A', 1, 3, '40.jpg'],
                [41, 41, 'Light  Violet', '18-3520', '#75568C', 2, 4, '41.jpg'],
                [41, 41, 'Light  Violet', '18-3520', '#75568C', 2, 1, '41.jpg'],
                [42, 42, 'Lavender', '16-3823', '#9B90C8', 2, 4, '42.jpg'],
                [42, 42, 'Lavender', '16-3823', '#9B90C8', 2, 1, '42.jpg'],
                [43, 43, 'Periwinkle', '18-3930', '#6874A1', 1, 1, '43.jpg'],
                [43, 43, 'Periwinkle', '18-3930', '#6874A1', 1, 6, '43.jpg'],
                [44, 44, 'Sky Blue', '14-4214', '#96B3D1', 2, 5, '44.jpg'],
                [44, 44, 'Sky Blue', '14-4214', '#96B3D1', 2, 4, '44.jpg'],
                [44, 44, 'Sky Blue', '14-4214', '#96B3D1', 2, 1, '44.jpg'],
                [45, 45, 'Light Periwinkle Blue', '16-3920', '#8A9CC4', 2, 1, '45.jpg'],
                [46, 46, 'Bright Light Blue', '15-4225', '#6DACD6', 1, 3, '46.jpg'],
                [46, 46, 'Bright Light Blue', '15-4225', '#6DACD6', 1, 1, '46.jpg'],
                [46, 46, 'Bright Light Blue', '15-4225', '#6DACD6', 2, 3, '46.jpg'],
                [46, 46, 'Bright Light Blue', '15-4225', '#6DACD6', 2, 1, '46.jpg'],
                [47, 47, 'Pastel Aqua', '14-4516', '#85C6D7', 2, 4, '47.jpg'],
                [47, 47, 'Pastel Aqua', '14-4516', '#85C6D7', 2, 1, '47.jpg'],
                [48, 48, 'Powder Blue', '14-4318', '#8CBED6', 2, 5, '48.jpg'],
                [48, 48, 'Powder Blue', '14-4318', '#8CBED6', 2, 4, '48.jpg'],
                [48, 48, 'Powder Blue', '14-4318', '#8CBED6', 2, 1, '48.jpg'],
                [49, 49, 'Pine Green', '19-5914', '#40524E', 4, 2, '49.jpg'],
                [49, 49, 'Pine Green', '19-5914', '#40524E', 4, 5, '49.jpg'],
                [50, 50, 'Forest Green', '19-0315', '#405241', 3, 4, '50.jpg'],
                [50, 50, 'Forest Green', '19-0315', '#405241', 3, 2, '50.jpg'],
                [50, 50, 'Forest Green', '19-0315', '#405241', 3, 6, '50.jpg'],
                [51, 51, 'Emerald Green', '18-5633', '#007E5E', 4, 2, '51.jpg'],
                [51, 51, 'Emerald Green', '18-5633', '#007E5E', 4, 3, '51.jpg'],
                [51, 51, 'Emerald Green', '18-5633', '#007E5E', 4, 5, '51.jpg'],
                [52, 52, 'Emerald Turquoise', '16-5431', '#00A989', 1, 6, '52.jpg'],
                [52, 52, 'Emerald Turquoise', '16-5431', '#00A989', 1, 1, '52.jpg'],
                [53, 53, 'Light Emerald Turqu', '15-5416', '#48C1AA', 1, 3, '53.jpg'],
                [53, 53, 'Light Emerald Turqu', '15-5416', '#48C1AA', 2, 3, '53.jpg'],
                [53, 53, 'Light Emerald Turqu', '15-5416', '#48C1AA', 1, 1, '53.jpg'],
                [53, 53, 'Light Emerald Turqu', '15-5416', '#48C1AA', 2, 1, '53.jpg'],
                [54, 54, 'True Green', '18-6024', '#1C734B', 4, 5, '54.jpg'],
                [54, 54, 'True Green', '18-6024', '#1C734B', 4, 3, '54.jpg'],
                [54, 54, 'True Green', '18-6024', '#1C734B', 4, 2, '54.jpg'],
                [55, 55, 'Light True Green', '16-6127', '#409C6A', 4, 3, '55.jpg'],
                [55, 55, 'Light True Green', '16-6127', '#409C6A', 4, 2, '55.jpg'],
                [56, 56, 'Dark Yellow Green', '17-6333', '#51814F', 3, 6, '56.jpg'],
                [56, 56, 'Dark Yellow Green', '17-6333', '#51814F', 3, 2, '56.jpg'],
                [57, 57, 'Bright True Green', '16-6138', '#199D5C', 1, 3, '57.jpg'],
                [57, 57, 'Bright True Green', '16-6138', '#199D5C', 1, 6, '57.jpg'],
                [58, 58, 'Light Yellow Green', '14-6329', '#73B881', 1, 1, '58.jpg'],
                [58, 58, 'Light Yellow Green', '14-6329', '#73B881', 1, 6, '58.jpg'],
                [58, 58, 'Light Yellow Green', '14-6329', '#73B881', 1, 3, '58.jpg'],
                [59, 59, 'Yellow Green', '15-6432', '#74A56A', 3, 6, '59.jpg'],
                [59, 59, 'Yellow Green', '15-6432', '#74A56A', 3, 2, '59.jpg'],
                [60, 60, 'Lime Green', '15-0343', '#91B54D', 3, 3, '60.jpg'],
                [60, 60, 'Lime Green', '15-0343', '#91B54D', 3, 6, '60.jpg'],
                [61, 61, 'Muted Turquoise', '17-4818', '#4E9093', 2, 4, '61.jpg'],
                [61, 61, 'Muted Turquoise', '17-4818', '#4E9093', 3, 4, '61.jpg'],
                [62, 62, 'Dark Teal', '18-4522', '#296673', 3, 6, '62.jpg'],
                [62, 62, 'Dark Teal', '18-4522', '#296673', 3, 4, '62.jpg'],
                [62, 62, 'Dark Teal', '18-4522', '#296673', 3, 2, '62.jpg'],
                [63, 63, 'Teal Blue', '18-4718', '#3E6873', 3, 2, '63.jpg'],
                [63, 63, 'Teal Blue', '18-4718', '#3E6873', 3, 4, '63.jpg'],
                [64, 64, 'Light Warm Aqua', '15-4722', '#42BDCB', 1, 6, '64.jpg'],
                [64, 64, 'Light Warm Aqua', '15-4722', '#42BDCB', 1, 3, '64.jpg'],
                [64, 64, 'Light Warm Aqua', '15-4722', '#42BDCB', 1, 1, '64.jpg'],
                [65, 65, 'Chinese Blue', '18-4252', '#007BBD', 4, 5, '65.jpg'],
                [65, 65, 'Chinese Blue', '18-4252', '#007BBD', 4, 3, '65.jpg'],
                [65, 65, 'Chinese Blue', '18-4252', '#007BBD', 4, 2, '65.jpg'],
                [66, 66, 'Hot Turquoise', '17-4433', '#008AC2', 4, 2, '66.jpg'],
                [66, 66, 'Hot Turquoise', '17-4433', '#008AC2', 4, 5, '66.jpg'],
                [66, 66, 'Hot Turquoise', '17-4433', '#008AC2', 4, 3, '66.jpg'],
                [67, 67, 'Clear Bright Aqua', '14-4522', '#43BCD8', 1, 1, '67.jpg'],
                [67, 67, 'Clear Bright Aqua', '14-4522', '#43BCD8', 1, 6, '67.jpg'],
                [67, 67, 'Clear Bright Aqua', '14-4522', '#43BCD8', 1, 3, '67.jpg'],
                [68, 68, 'Deep Blue Green', '17-5029', '#008684', 2, 4, '68.jpg'],
                [68, 68, 'Deep Blue Green', '17-5029', '#008684', 2, 5, '68.jpg'],
                [69, 69, 'Med. Blue Green', '16-5123', '#1A9A9D', 2, 5, '69.jpg'],
                [69, 69, 'Med. Blue Green', '16-5123', '#1A9A9D', 2, 4, '69.jpg'],
                [70, 70, 'Turquoise', '15-5421', '#00BCA1', 3, 2, '70.jpg'],
                [70, 70, 'Turquoise', '15-5421', '#00BCA1', 3, 4, '70.jpg'],
                [70, 70, 'Turquoise', '15-5421', '#00BCA1', 3, 6, '70.jpg'],
                [71, 71, 'Pastel Blue Green', '14-5714', '#7DCFB6', 2, 5, '71.jpg'],
                [71, 71, 'Pastel Blue Green', '14-5714', '#7DCFB6', 2, 4, '71.jpg'],
                [71, 71, 'Pastel Blue Green', '14-5714', '#7DCFB6', 2, 1, '71.jpg'],
                [72, 72, 'Jade Green', '14-0121', '#AACA97', 3, 2, '72.jpg'],
                [72, 72, 'Jade Green', '14-0121', '#AACA97', 3, 6, '72.jpg'],
                [72, 72, 'Jade Green', '14-0121', '#AACA97', 3, 4, '72.jpg'],
                [73, 73, 'Dark Mahogany', '19-1331', '#6C3A3C', 3, 6, '73.jpg'],
                [73, 73, 'Dark Mahogany', '19-1331', '#6C3A3C', 3, 2, '73.jpg'],
                [73, 73, 'Dark Mahogany', '19-1331', '#6C3A3C', 3, 4, '73.jpg'],
                [74, 74, 'Mahogany', '18-1425', '#814A47', 3, 2, '74.jpg'],
                [74, 74, 'Mahogany', '18-1425', '#814A47', 3, 6, '74.jpg'],
                [74, 74, 'Mahogany', '18-1425', '#814A47', 3, 4, '74.jpg'],
                [75, 75, 'Rust', '18-1444', '#9D4844', 3, 6, '75.jpg'],
                [75, 75, 'Rust', '18-1444', '#9D4844', 3, 2, '75.jpg'],
                [75, 75, 'Rust', '18-1444', '#9D4844', 3, 4, '75.jpg'],
                [76, 76, 'Bright Burgundy', '17-1623', '#7E314D', 4, 2, '76.jpg'],
                [76, 76, 'Bright Burgundy', '17-1623', '#7E314D', 4, 3, '76.jpg'],
                [76, 76, 'Bright Burgundy', '17-1623', '#7E314D', 4, 5, '76.jpg'],
                [77, 77, 'Burgundy', '19-2025', '#A55972', 2, 5, '77.jpg'],
                [77, 77, 'Burgundy', '19-2025', '#A55972', 2, 1, '77.jpg'],
                [77, 77, 'Burgundy', '19-2025', '#A55972', 2, 4, '77.jpg'],
                [78, 78, 'Aubergine', '19-3316', '#483A49', 4, 2, '78.jpg'],
                [78, 78, 'Aubergine', '19-3316', '#483A49', 3, 5, '78.jpg'],
                [78, 78, 'Aubergine', '19-3316', '#483A49', 4, 5, '78.jpg'],
                [78, 78, 'Aubergine', '19-3316', '#483A49', 3, 4, '78.jpg'],
                [78, 78, 'Aubergine', '19-3316', '#483A49', 4, 4, '78.jpg'],
                [78, 78, 'Aubergine', '19-3316', '#483A49', 3, 2, '78.jpg'],
                [79, 79, 'Plum', '19-3325', '#764672', 2, 5, '79.jpg'],
                [80, 80, 'Fuchsia', '19-2431', '#873260', 4, 2, '80.jpg'],
                [80, 80, 'Fuchsia', '19-2431', '#873260', 4, 5, '80.jpg'],
                [81, 81, 'Soft Fuchsia', '18-2525', '#9F4576', 2, 1, '81.jpg'],
                [81, 81, 'Soft Fuchsia', '18-2525', '#9F4576', 2, 5, '81.jpg'],
                [81, 81, 'Soft Fuchsia', '18-2525', '#9F4576', 2, 4, '81.jpg'],
                [82, 82, 'Mauve', '16-2120', '#D770A2', 2, 5, '82.jpg'],
                [82, 82, 'Mauve', '16-2120', '#D770A2', 2, 1, '82.jpg'],
                [82, 82, 'Mauve', '16-2120', '#D770A2', 2, 4, '82.jpg'],
                [83, 83, 'Orchid', '16-3118', '#DB8AC3', 2, 5, '83.jpg'],
                [83, 83, 'Orchid', '16-3118', '#DB8AC3', 2, 1, '83.jpg'],
                [84, 84, 'Grey Violet', '18-3715', '#6B5D74', 2, 2, '84.jpg'],
                [84, 84, 'Grey Violet', '18-3715', '#6B5D74', 2, 4, '84.jpg'],
                [84, 84, 'Grey Violet', '18-3715', '#6B5D74', 3, 2, '84.jpg'],
                [84, 84, 'Grey Violet', '18-3715', '#6B5D74', 3, 4, '84.jpg'],
                [85, 85, 'Raspberry', '17-2031', '#C3447A', 2, 2, '85.jpg'],
                [85, 85, 'Raspberry', '17-2031', '#C3447A', 2, 3, '85.jpg'],
                [85, 85, 'Raspberry', '17-2031', '#C3447A', 2, 5, '85.jpg'],
                [86, 86, 'Magenta', '17-2036', '#D0417E', 4, 3, '86.jpg'],
                [86, 86, 'Magenta', '17-2036', '#D0417E', 4, 2, '86.jpg'],
                [86, 86, 'Magenta', '17-2036', '#D0417E', 4, 5, '86.jpg'],
                [87, 87, 'Deep Hot Pink', '18-2043', '#CC3A71', 4, 2, '87.jpg'],
                [87, 87, 'Deep Hot Pink', '18-2043', '#CC3A71', 4, 5, '87.jpg'],
                [87, 87, 'Deep Hot Pink', '18-2043', '#CC3A71', 4, 3, '87.jpg'],
                [88, 88, 'Clear Bright Pink', '16-1731', '#F87B90', 1, 1, '88.jpg'],
                [88, 88, 'Clear Bright Pink', '16-1731', '#F87B90', 1, 6, '88.jpg'],
                [88, 88, 'Clear Bright Pink', '16-1731', '#F87B90', 1, 3, '88.jpg'],
                [89, 89, 'Carnation', '19-1762', '#AD1C42', 2, 4, '89.jpg'],
                [89, 89, 'Carnation', '19-1762', '#AD1C42', 2, 5, '89.jpg'],
                [90, 90, 'Bright Coral', '17-1736', '#E5697B', 1, 6, '90.jpg'],
                [90, 90, 'Bright Coral', '17-1736', '#E5697B', 1, 3, '90.jpg'],
                [90, 90, 'Bright Coral', '17-1736', '#E5697B', 1, 1, '90.jpg'],
                [91, 91, 'Coral Pink', '17-1928', '#E87191', 1, 1, '91.jpg'],
                [91, 91, 'Coral Pink', '17-1928', '#E87191', 1, 3, '91.jpg'],
                [91, 91, 'Coral Pink', '17-1928', '#E87191', 1, 6, '91.jpg'],
                [92, 92, 'Rose Pink', '17-2120', '#D27497', 2, 5, '92.jpg'],
                [92, 92, 'Rose Pink', '17-2120', '#D27497', 2, 4, '92.jpg'],
                [92, 92, 'Rose Pink', '17-2120', '#D27497', 2, 1, '92.jpg'],
                [93, 93, 'Shocking Pink', '15-2217', '#E680AA', 4, 3, '93.jpg'],
                [93, 93, 'Shocking Pink', '15-2217', '#E680AA', 4, 2, '93.jpg'],
                [93, 93, 'Shocking Pink', '15-2217', '#E680AA', 4, 5, '93.jpg'],
                [94, 94, 'Pastel Pink', '14-2311', '#EFA5C8', 2, 1, '94.jpg'],
                [94, 94, 'Pastel Pink', '14-2311', '#EFA5C8', 2, 4, '94.jpg'],
                [95, 95, 'Powder Pink', '14-2808', '#E7B8D3', 2, 1, '95.jpg'],
                [95, 95, 'Powder Pink', '14-2808', '#E7B8D3', 2, 5, '95.jpg'],
                [95, 95, 'Powder Pink', '14-2808', '#E7B8D3', 2, 4, '95.jpg'],
                [96, 96, 'Muted Pink', '15-1816', '#ED9FAE', 2, 4, '96.jpg'],
                [96, 96, 'Muted Pink', '15-1816', '#ED9FAE', 3, 4, '96.jpg'],
                [97, 97, 'Terracotta', '17-1553', '#C84B45', 3, 6, '97.jpg'],
                [97, 97, 'Terracotta', '17-1553', '#C84B45', 3, 4, '97.jpg'],
                [97, 97, 'Terracotta', '17-1553', '#C84B45', 3, 2, '97.jpg'],
                [98, 98, 'Orange', '16-1452', '#F16B46', 3, 6, '98.jpg'],
                [98, 98, 'Orange', '16-1452', '#F16B46', 3, 2, '98.jpg'],
                [99, 99, 'Salmon', '17-1644', '#D66467', 3, 6, '99.jpg'],
                [99, 99, 'Salmon', '17-1644', '#D66467', 3, 2, '99.jpg'],
                [99, 99, 'Salmon', '17-1644', '#D66467', 3, 4, '99.jpg'],
                [100, 100, 'Deep Peach', '17-1547', '#E4665C', 3, 6, '100.jpg'],
                [100, 100, 'Deep Peach', '17-1547', '#E4665C', 3, 2, '100.jpg'],
                [101, 101, 'Clear Salmon', '16-1632', '#F28085', 1, 3, '101.jpg'],
                [101, 101, 'Clear Salmon', '16-1632', '#F28085', 1, 1, '101.jpg'],
                [101, 101, 'Clear Salmon', '16-1632', '#F28085', 1, 6, '101.jpg'],
                [102, 102, 'Medium Apricot', '15-1433', '#FEA188', 1, 1, '102.jpg'],
                [102, 102, 'Medium Apricot', '15-1433', '#FEA188', 1, 6, '102.jpg'],
                [103, 103, 'Muted Apricot', '16-1526', '#CE7F75', 3, 2, '103.jpg'],
                [103, 103, 'Muted Apricot', '16-1526', '#CE7F75', 3, 4, '103.jpg'],
                [104, 104, 'Warm Pastel Pink', '13-1409', '#F8CBC7', 1, 1, '104.jpg'],
                [104, 104, 'Warm Pastel Pink', '13-1409', '#F8CBC7', 1, 3, '104.jpg'],
                [105, 105, 'Peach', '14-1418', '#FABCB1', 1, 1, '105.jpg'],
                [105, 105, 'Peach', '14-1418', '#FABCB1', 1, 3, '105.jpg'],
                [106, 106, 'Light Apricot', '13-1020', '#FFC49D', 1, 1, '106.jpg'],
                [106, 106, 'Light Apricot', '13-1020', '#FFC49D', 1, 6, '106.jpg'],
                [107, 107, 'Soft Peach', '12-1011', '#F3D1B9', 2, 1, '107.jpg'],
                [107, 107, 'Soft Peach', '12-1011', '#F3D1B9', 1, 4, '107.jpg'],
                [107, 107, 'Soft Peach', '12-1011', '#F3D1B9', 2, 4, '107.jpg'],
                [107, 107, 'Soft Peach', '12-1011', '#F3D1B9', 1, 1, '107.jpg'],
                [108, 108, 'Natural Beige', '14-1217', '#DEB99D', 3, 6, '108.jpg'],
                [108, 108, 'Natural Beige', '14-1217', '#DEB99D', 3, 4, '108.jpg'],
                [108, 108, 'Natural Beige', '14-1217', '#DEB99D', 3, 2, '108.jpg'],
                [109, 109, 'White', 'Optic whit', '#ffffff', 4, 3, '109.jpg'],
                [109, 109, 'White', 'Optic whit', '#ffffff', 4, 2, '109.jpg'],
                [109, 109, 'White', 'Optic whit', '#ffffff', 4, 5, '109.jpg'],
                [110, 110, 'Soft White', '12-1106 on', '#F4EAE0', 2, 1, '110.jpg'],
                [110, 110, 'Soft White', '12-1106 on', '#F4EAE0', 2, 6, '110.jpg'],
                [110, 110, 'Soft White', '12-1106 on', '#F4EAE0', 2, 5, '110.jpg'],
                [110, 110, 'Soft White', '12-1106 on', '#F4EAE0', 2, 4, '110.jpg'],
                [111, 111, 'Ivory White', 'no match b', '#f9f9f9', 1, 1, '111.jpg'],
                [111, 111, 'Ivory White', 'no match b', '#f9f9f9', 1, 3, '111.jpg'],
                [112, 112, 'Light Warm Beige', '12-0812', '#F0E1BF', 1, 6, '112.jpg'],
                [112, 112, 'Light Warm Beige', '12-0812', '#F0E1BF', 1, 1, '112.jpg'],
                [113, 113, 'Ivory', '11-0507', '#F2EDD8', 1, 1, '113.jpg'],
                [113, 113, 'Ivory', '11-0507', '#F2EDD8', 1, 3, '113.jpg'],
                [114, 114, 'Oyster', '12-1106', '#F4EAE0', 3, 6, '114.jpg'],
                [114, 114, 'Oyster', '12-1106', '#F4EAE0', 3, 2, '114.jpg'],
                [114, 114, 'Oyster', '12-1106', '#F4EAE0', 3, 4, '114.jpg'],
                [115, 115, 'Rose Beige', '13-1406', '#F0D3C9', 2, 5, '115.jpg'],
                [115, 115, 'Rose Beige', '13-1406', '#F0D3C9', 2, 4, '115.jpg'],
                [115, 115, 'Rose Beige', '13-1406', '#F0D3C9', 2, 1, '115.jpg'],
                [116, 116, 'Icy Blue', '13-4304', '#BFCFDD', 4, 2, '116.jpg'],
                [116, 116, 'Icy Blue', '13-4304', '#BFCFDD', 4, 3, '116.jpg'],
                [117, 117, 'Icy Violet', '13-3805', '#CEC4D7', 4, 2, '117.jpg'],
                [117, 117, 'Icy Violet', '13-3805', '#CEC4D7', 4, 3, '117.jpg'],
                [118, 118, 'Icy Pink', '12-1304', '#F5DDDA', 4, 3, '118.jpg'],
                [118, 118, 'Icy Pink', '12-1304', '#F5DDDA', 4, 2, '118.jpg'],
                [119, 119, 'Icy Aqua', '12-5603', '#D5DDD5', 4, 3, '119.jpg'],
                [119, 119, 'Icy Aqua', '12-5603', '#D5DDD5', 4, 2, '119.jpg'],
                [120, 120, 'Icy Green', '12-5201', '#DFE1D5', 4, 3, '120.jpg'],
                [120, 120, 'Icy Green', '12-5201', '#DFE1D5', 4, 2, '120.jpg'],
                [121, 121, 'Dark Chocolate Brown ', '19-1012', '#594440', 3, 2, '121.jpg'],
                [122, 122, 'Coffee Brown', '18-1222', '#6B5043', 3, 6, '122.jpg'],
                [122, 122, 'Coffee Brown', '18-1222', '#6B5043', 3, 4, '122.jpg'],
                [122, 122, 'Coffee Brown', '18-1222', '#6B5043', 3, 2, '122.jpg'],
                [123, 123, 'Rose Brown', '18-1421', '#886159', 2, 5, '123.jpg'],
                [123, 123, 'Rose Brown', '18-1421', '#886159', 2, 4, '123.jpg'],
                [123, 123, 'Rose Brown', '18-1421', '#886159', 2, 1, '123.jpg'],
                [124, 124, 'Dark Taupe', '18-1314', '#7C6054', 4, 2, '124.jpg'],
                [125, 125, 'Medium Bronze', '18-0928', '#6C5740', 3, 4, '125.jpg'],
                [125, 125, 'Medium Bronze', '18-0928', '#6C5740', 3, 2, '125.jpg'],
                [125, 125, 'Medium Bronze', '18-0928', '#6C5740', 3, 6, '125.jpg'],
                [126, 126, 'Medium Golden Brown ', '18-1154', '#935931', 1, 1, '126.jpg'],
                [126, 126, 'Medium Golden Brown ', '18-1154', '#935931', 1, 6, '126.jpg'],
                [126, 126, 'Medium Golden Brown ', '18-1154', '#935931', 1, 2, '126.jpg'],
                [127, 127, 'Golden Tan', '16-1432', '#AB784E', 1, 1, '127.jpg'],
                [127, 127, 'Golden Tan', '16-1432', '#AB784E', 1, 6, '127.jpg'],
                [128, 128, 'Cocoa', '17-1417', '#947563', 2, 5, '128.jpg'],
                [128, 128, 'Cocoa', '17-1417', '#947563', 2, 4, '128.jpg'],
                [128, 128, 'Cocoa', '17-1417', '#947563', 2, 1, '128.jpg'],
                [129, 129, 'Camel', '16-1336', '#B6855A', 3, 2, '129.jpg'],
                [129, 129, 'Camel', '16-1336', '#B6855A', 3, 4, '129.jpg'],
                [129, 129, 'Camel', '16-1336', '#B6855A', 3, 6, '129.jpg'],
                [130, 130, 'Light Camel', '13-1018', '#E5BD8E', 1, 1, '130.jpg'],
                [130, 130, 'Light Camel', '13-1018', '#E5BD8E', 1, 6, '130.jpg'],
                [131, 131, 'Warm Beige', '13-1016', '#E3C7A6', 3, 2, '131.jpg'],
                [131, 131, 'Warm Beige', '13-1016', '#E3C7A6', 3, 6, '131.jpg'],
                [131, 131, 'Warm Beige', '13-1016', '#E3C7A6', 3, 4, '131.jpg'],
                [132, 132, 'Taupe', '13-1011', '#DEC6AC', 4, 5, '132.jpg'],
                [132, 132, 'Taupe', '13-1011', '#DEC6AC', 4, 2, '132.jpg'],
                [132, 132, 'Taupe', '13-1011', '#DEC6AC', 4, 3, '132.jpg'],
                [133, 133, 'Black', '19-4205', '#34373B', 4, 3, '133.jpg'],
                [133, 133, 'Black', '19-4205', '#34373B', 4, 5, '133.jpg'],
                [133, 133, 'Black', '19-4205', '#34373B', 4, 2, '133.jpg'],
                [134, 134, 'Charcoal Grey', '19-3903', '#433D42', 4, 5, '134.jpg'],
                [134, 134, 'Charcoal Grey', '19-3903', '#433D42', 4, 2, '134.jpg'],
                [134, 134, 'Charcoal Grey', '19-3903', '#433D42', 4, 3, '134.jpg'],
                [135, 135, 'Autumn Grey', '17-0205', '#908D87', 3, 6, '135.jpg'],
                [135, 135, 'Autumn Grey', '17-0205', '#908D87', 3, 4, '135.jpg'],
                [135, 135, 'Autumn Grey', '17-0205', '#908D87', 3, 2, '135.jpg'],
                [136, 136, 'Dark Olive', '19-0618', '#544B32', 3, 2, '136.jpg'],
                [136, 136, 'Dark Olive', '19-0618', '#544B32', 3, 4, '136.jpg'],
                [137, 137, 'Moss Green', '18-0527', '#706F48', 3, 6, '137.jpg'],
                [137, 137, 'Moss Green', '18-0527', '#706F48', 3, 2, '137.jpg'],
                [137, 137, 'Moss Green', '18-0527', '#706F48', 3, 4, '137.jpg'],
                [138, 138, 'Olive Green', '18-0521', '#6A6855', 3, 4, '138.jpg'],
                [138, 138, 'Olive Green', '18-0521', '#6A6855', 3, 2, '138.jpg'],
                [138, 138, 'Olive Green', '18-0521', '#6A6855', 3, 6, '138.jpg'],
                [139, 139, 'Green Grey', '17-0610', '#8B8A79', 3, 2, '139.jpg'],
                [139, 139, 'Green Grey', '17-0610', '#8B8A79', 3, 4, '139.jpg'],
                [139, 139, 'Green Grey', '17-0610', '#8B8A79', 3, 6, '139.jpg'],
                [140, 140, 'Light Green Grey', '15-6307', '#B4B5A5', 2, 4, '140.jpg'],
                [140, 140, 'Light Green Grey', '15-6307', '#B4B5A5', 3, 4, '140.jpg'],
                [141, 141, 'Light Warm Grey', '14-1209', '#CBB7A2', 1, 6, '141.jpg'],
                [141, 141, 'Light Warm Grey', '14-1209', '#CBB7A2', 1, 1, '141.jpg'],
                [141, 141, 'Light Warm Grey', '14-1209', '#CBB7A2', 1, 3, '141.jpg'],
                [142, 142, 'Light True Grey', '14-4203', '#BDBEBF', 4, 2, '142.jpg'],
                [142, 142, 'Light True Grey', '14-4203', '#BDBEBF', 4, 3, '142.jpg'],
                [142, 142, 'Light True Grey', '14-4203', '#BDBEBF', 4, 5, '142.jpg'],
                [143, 143, 'Medium True Grey', '17-4402', '#898E8C', 4, 5, '143.jpg'],
                [143, 143, 'Medium True Grey', '17-4402', '#898E8C', 4, 3, '143.jpg'],
                [143, 143, 'Medium True Grey', '17-4402', '#898E8C', 4, 2, '143.jpg'],
                [144, 144, 'Light Blue Grey', '14-4206', '#AEBAC1', 2, 4, '144.jpg'],
                [144, 144, 'Light Blue Grey', '14-4206', '#AEBAC1', 2, 5, '144.jpg'],
                [144, 144, 'Light Blue Grey', '14-4206', '#AEBAC1', 2, 1, '144.jpg'],
                [145, 145, 'Medium Blue Grey', '18-3918', '#53677A', 2, 1, '145.jpg'],
                [145, 145, 'Medium Blue Grey', '18-3918', '#53677A', 2, 5, '145.jpg'],
                [146, 146, 'Bright Navy', '19-3935', '#3E4465', 4, 2, '146.jpg'],
                [146, 146, 'Bright Navy', '19-3935', '#3E4465', 4, 5, '146.jpg'],
                [146, 146, 'Bright Navy', '19-3935', '#3E4465', 4, 3, '146.jpg'],
                [147, 148, 'Muted Navy', '19-3928', '#485470', 2, 5, '148.jpg'],
                [147, 148, 'Muted Navy', '19-3928', '#485470', 2, 4, '148.jpg'],
                [148, 149, 'Bright Purple', '18-3838', '#645394', 4, 3, '149.jpg'],
                [148, 149, 'Bright Purple', '18-3838', '#645394', 1, 3, '149.jpg'],
                [149, 151, 'Blue Violet', '19-3839', '#3D3E63', 4, 5, '151.jpg'],
                [149, 151, 'Blue Violet', '19-3839', '#3D3E63', 4, 2, '151.jpg'],
                [150, 152, 'Dark Medium Grey', '18-0601', '#6A6A6A', 4, 5, '152.jpg'],
                [150, 152, 'Dark Medium Grey', '18-0601', '#6A6A6A', 4, 3, '152.jpg'],
                [151, 153, 'Cool Taupe', '18-1306', '#6E605D', 4, 2, '153.jpg'],
                [151, 153, 'Cool Taupe', '18-1306', '#6E605D', 4, 5, '153.jpg'],
                [152, 154, 'Black/Brown', '19-1314', '#413433', 4, 2, '154.jpg'],
                [152, 154, 'Black/Brown', '19-1314', '#413433', 3, 2, '154.jpg'],
                [153, 155, 'Bright Orange', '17-1562', '#E74D3A', 3, 2, '155.jpg'],
                [153, 155, 'Bright Orange', '17-1562', '#E74D3A', 1, 2, '155.jpg'],
                [153, 155, 'Bright Orange', '17-1562', '#E74D3A', 3, 6, '155.jpg'],
                [153, 155, 'Bright Orange', '17-1562', '#E74D3A', 3, 3, '155.jpg'],
                [153, 155, 'Bright Orange', '17-1562', '#E74D3A', 1, 6, '155.jpg'],
                [153, 155, 'Bright Orange', '17-1562', '#E74D3A', 1, 3, '155.jpg'],
                [154, 156, 'Icy Grey', '13-4105', '#D5D5DE', 4, 3, '156.jpg'],
                [154, 156, 'Icy Grey', '13-4105', '#D5D5DE', 4, 5, '156.jpg'],
                [155, 157, 'New Aubergine', '19-1606', '#57414A', 3, 6, '157.jpg'],
                [155, 157, 'New Aubergine', '19-1606', '#57414A', 3, 4, '157.jpg'],
                [155, 157, 'New Aubergine', '19-1606', '#57414A', 3, 2, '157.jpg'],
                [156, 158, 'New Burgundy', '19-1526', '#61373F', 4, 2, '158.jpg'],
                [156, 158, 'New Burgundy', '19-1526', '#61373F', 4, 5, '158.jpg'],
                [157, 159, 'New Blue Red', '18-1760', '#B61745', 4, 3, '159.jpg'],
                [157, 159, 'New Blue Red', '18-1760', '#B61745', 4, 5, '159.jpg'],
                [157, 159, 'New Blue Red', '18-1760', '#B61745', 4, 2, '159.jpg'],
                [158, 160, 'New Fuchsia', '18-2336', '#BA397B', 4, 2, '160.jpg'],
                [158, 160, 'New Fuchsia', '18-2336', '#BA397B', 4, 5, '160.jpg'],
                [159, 161, 'Cadet Blue', '19-4039', '#3A5B8D', 2, 4, '161.jpg'],
                [159, 161, 'Cadet Blue', '19-4039', '#3A5B8D', 2, 5, '161.jpg'],
                [160, 162, 'New Taupe', '16-1412', '#A48D7F', 1, 1, '162.jpg'],
                [161, 163, 'New Camel', '16-1143', '#CC9350', 1, 6, '163.jpg'],
                [161, 163, 'New Camel', '16-1143', '#CC9350', 3, 6, '163.jpg'],
                [162, 164, 'Light Teal', '18-4726', '#007784', 1, 1, '164.jpg'],
                [162, 164, 'Light Teal', '18-4726', '#007784', 1, 6, '164.jpg'],
                [162, 164, 'Light Teal', '18-4726', '#007784', 1, 3, '164.jpg'],
                [163, 165, 'New Teal', '19-4922', '#006465', 3, 4, '165.jpg'],
                [163, 165, 'New Teal', '19-4922', '#006465', 3, 6, '165.jpg'],
                [163, 165, 'New Teal', '19-4922', '#006465', 3, 2, '165.jpg'],
                [164, 166, 'Light Moss', '15-6317', '#A2C49B', 2, 1, '166.jpg'],
                [164, 166, 'Light Moss', '15-6317', '#A2C49B', 3, 1, '166.jpg'],
                [164, 166, 'Light Moss', '15-6317', '#A2C49B', 2, 4, '166.jpg'],
                [164, 166, 'Light Moss', '15-6317', '#A2C49B', 3, 4, '166.jpg'],
                [165, 167, 'New Emerald Green', '17-6229', '#4A8556', 4, 2, '167.jpg'],
                [165, 167, 'New Emerald Green', '17-6229', '#4A8556', 4, 3, '167.jpg'],
                [165, 167, 'New Emerald Green', '17-6229', '#4A8556', 4, 5, '167.jpg'],
                [166, 168, 'New Pine Green', '19-5914', '#2D5C5A', 4, 2, '168.jpg'],
                [166, 168, 'New Pine Green', '19-5914', '#2D5C5A', 4, 5, '168.jpg'],
                [167, 169, 'New Coral', '17-1656', '#ED5656', 1, 3, '169.jpg'],
                [167, 169, 'New Coral', '17-1656', '#ED5656', 1, 6, '169.jpg'],
                [168, 170, 'Green Sulphur', '16-0742', '#AF8E31', 1, 6, '170.jpg'],
                [168, 170, 'Green Sulphur', '16-0742', '#AF8E31', 3, 6, '170.jpg'],
                [169, 171, 'Almond Cream', '16-1510', '#B09793', 2, 2, '171.jpg'],
                [169, 171, 'Almond Cream', '16-1510', '#B09793', 4, 2, '171.jpg'],
                [169, 171, 'Almond Cream', '16-1510', '#B09793', 2, 5, '171.jpg'],
                [169, 171, 'Almond Cream', '16-1510', '#B09793', 4, 5, '171.jpg'],
                [169, 171, 'Almond Cream', '16-1510', '#B09793', 2, 1, '171.jpg'],
                [169, 171, 'Almond Cream', '16-1510', '#B09793', 4, 1, '171.jpg'],
                [170, 301, 'Bright Metallic Gold', '16-0836', '#B49B57', 1, 6, '301.jpg'],
                [170, 301, 'Bright Metallic Gold', '16-0836', '#B49B57', 1, 3, '301.jpg'],
                [171, 302, 'Bright Metallic Silver', '14-5002', '#999B9B', 4, 5, '302.jpg'],
                [171, 302, 'Bright Metallic Silver', '14-5002', '#999B9B', 4, 3, '302.jpg'],
                [172, 303, 'Antique Metallic Silver', '??????', '#7a7e7e', 2, 5, '303.jpg'],
                [172, 303, 'Antique Metallic Silver', '??????', '#7a7e7e', 2, 4, '303.jpg'],
                [173, 304, 'Antique Metallic Gold ', '15-0927', '#B78B5F', 3, 4, '304.jpg'],
                [173, 304, 'Antique Metallic Gold ', '15-0927', '#B78B5F', 3, 6, '304.jpg'],
                [201, 305, 'Gold Leopard', '15-1142', '#d5a155', 1, 6, '305.jpg'],
                [201, 305, 'Gold Leopard', '15-1142', '#d5a155', 3, 6, '305.jpg'],
                [202, 306, 'Silver Leopard', '14-4110', '#bdc5db', 2, 5, '306.jpg'],
                [202, 306, 'Silver Leopard', '14-4110', '#bdc5db', 4, 5, '306.jpg']
        ]

        allcolors.each {
            new Colour(
                    dc_id: it[1],
                    colorname: it[2],
                    pantone: it[3],
                    webcolor: it[4],
                    tone: Tone.fromInt(it[5]),
                    season: Season.fromInt(it[6]),
                    filename: it[7],
            ).save(failOnError: true)
        }

    }
    def destroy = {
    }
}
