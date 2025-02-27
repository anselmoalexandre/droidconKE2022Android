/*
 * Copyright 2022 DroidconKE
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android254.presentation.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.android254.presentation.R
import com.droidconke.chai.atoms.ChaiBlue
import com.droidconke.chai.atoms.ChaiLightGrey
import com.droidconke.chai.atoms.type.MontserratBold
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.google.accompanist.flowlayout.SizeMode

@Composable
fun SponsorsCard(
    modifier: Modifier = Modifier,
    sponsorsLogos: List<String>,
) {
    Card {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(
                    color = ChaiLightGrey,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(horizontal = 30.dp, vertical = 10.dp)
                .testTag("sponsors_section"),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.sponsors_title),
                style = TextStyle(
                    color = ChaiBlue,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    lineHeight = 25.sp,
                    fontFamily = MontserratBold,
                ),
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = Modifier.height(30.dp))

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.ic_droidcon_logo)
                    .build(),
                placeholder = painterResource(R.drawable.ic_google_logo_icon),
                contentDescription = stringResource(id = R.string.logo),
            )

            FlowRow(
                modifier = Modifier.padding(top = 16.dp),
                mainAxisAlignment = MainAxisAlignment.SpaceEvenly,
                mainAxisSize = SizeMode.Expand,
                mainAxisSpacing = 16.dp,
                crossAxisSpacing = 16.dp,
            ) {
                sponsorsLogos.forEach { sponsorLogo ->
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(R.drawable.ic_droidcon_logo)
                            .build(),
                        placeholder = painterResource(R.drawable.ic_google_logo_icon),
                        contentDescription = stringResource(id = R.string.logo),
                    )
                }
            }
        }
    }
}